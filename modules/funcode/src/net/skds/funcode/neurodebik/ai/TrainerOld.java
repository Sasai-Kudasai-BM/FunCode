package net.skds.funcode.neurodebik.ai;

import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;

public class TrainerOld {

	private static final Comparator<NetHolder> cmp = (c1, c2) -> Float.compare(c2.value, c1.value);

	private final SimpleNet[] children;
	private final NetHolder[] ratings;
	private final NetHolder[] branches;
	private final NNValidator validator;
	private final int childrenCount;
	private final int branchCount;
	private final float mutation;

	@Getter
	private int tc;
	@Getter
	private int cc;

	public TrainerOld(int children, int branches, SimpleNet root, NNValidator validator, float mutation) {
		this.mutation = mutation;
		this.childrenCount = children;
		this.branchCount = branches;
		this.validator = validator;
		this.children = new SimpleNet[children * branches];
		this.ratings = new NetHolder[this.children.length];
		this.branches = new NetHolder[branches];

		for (int b = 0; b < branchCount; b++) {
			this.branches[b] = new NetHolder(root.clone(), -Float.MAX_VALUE);
		}
		for (int i = 0; i < this.children.length; i++) {
			this.children[i] = new SimpleNet(root.getLayers(), root.getWidth(), root.inputSize(), root.outputSize(), root.getBias());
		}
	}

	private int index(int b, int c) {
		return b * childrenCount + c;
	}

	private void generate(float mutation) {
		for (int b = 0; b < branchCount; b++) {
			SimpleNet br = branches[b].net;
			for (int c = 0; c < childrenCount; c++) {
				int index = index(b, c);
				SimpleNet chi = children[index];
				chi.clone(br);
				chi.mutate(mutation);
			}
		}
	}

	private float compete() {
		float best = -Float.MAX_VALUE;
		for (int b = 0; b < branches.length; b++) {
			float rating = branches[b].value;
			if (rating > best) {
				best = rating;
			}
		}

		for (int c = 0; c < children.length; c++) {
			SimpleNet chi = children[c];
			float rating = validator.validate(chi);
			ratings[c] = new NetHolder(chi, rating);
		}
		Arrays.sort(ratings, cmp);
		//System.out.println(Arrays.toString(ratings));
		for (int b = 0; b < branchCount; b++) {
			NetHolder h = ratings[b];
			NetHolder br = branches[b];
			if (h.value > br.value) {
				if (h.value > best) {
					best = h.value;
				}
				br.net.clone(h.net);
				branches[b] = new NetHolder(br.net, h.value);
			}
		}
		return best;
	}

	public SimpleNet copyBest() {
		if (ratings[1] == null || cc != tc) {
			return null;
		}
		return ratings[1].net.clone();
	}

	public synchronized float train(int iterations) {
		float best = 0;
		this.tc = iterations;
		for (cc = 0; cc < tc; cc++) {
			//generate(5 * mutation / (i + 5));
			generate(mutation);
			best = compete();
			//System.out.println(best);
		}
		return best;
	}

	private record NetHolder(SimpleNet net, float value) {
	}
}
