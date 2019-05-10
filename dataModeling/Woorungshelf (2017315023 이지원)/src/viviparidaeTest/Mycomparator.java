package viviparidaeTest;

import java.util.Comparator;

public class Mycomparator implements Comparator<labeling>{

	@Override
	public int compare(labeling o1, labeling o2) {
		// TODO Auto-generated method stub
		return o1.getCnt() > o2.getCnt() ? -1 : (o1 == o2 ? 0 : 1);
	}

}
