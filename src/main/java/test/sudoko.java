package test;

public class sudoko {
	static int[][] su = { { 0, 0, 0, 6, 8, 0, 0, 0, 4 }, { 3, 0, 2, 9, 1, 5, 6, 0, 7 }, { 5, 6, 0, 0, 0, 7, 0, 1, 3 },
			{ 0, 5, 1, 0, 0, 9, 0, 2, 6 }, { 0, 2, 6, 8, 0, 0, 0, 0, 0 }, { 4, 0, 3, 0, 5, 6, 0, 0, 0 },
			{ 0, 0, 0, 0, 3, 0, 0, 7, 9 }, { 0, 0, 9, 0, 6, 0, 0, 3, 8 }, { 0, 3, 4, 0, 0, 0, 0, 6, 2 }

	};

	public static void main(String[] args) {
		int n = 8;
		//System.out.println(su.length);
		//System.out.println(su[1].length);
		sudoko sudo = new sudoko();
		
		sudo.slove();
		sudo.print(su);
	}

	private void slove() {

	}

	private void print(int[][] su) {
		for (int i = 0; i < su.length; i++) { // to run the loop 9 time verticaly
			if ((i) % 3 == 0) { // if it is first or 3rd or 6th etc it will this logic will seperate by =
				for (int j = 0; j < 9; j++) {
					System.out.print("===");
				}
				System.out.print("=" + "\n");
			}
			// this for loop will run to print all the values
			for (int j = 0; j < su.length; j++) {
				if ((j) % 3 == 0) {
					System.out.print(" | ");
				}
				System.out.print(su[i][j] + " ");
				if ((j + 1) == su.length) {
					System.out.print("|");
				}

			}
			System.out.println();

		}
		for (int j = 0; j < 9; j++) {
			System.out.print("===");
		}
		System.out.print("=" + "\n");
	}

}
