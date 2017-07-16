package newSet;

public class TimePlannerDemo {
	public static void main(String[] args) {
		int[][] slotsA = { { 10, 50 }, { 60, 120 }, { 140, 210 } };
		int[][] slotsB = { { 0, 15 }, { 60, 70 } };
		int duration = 8;
		int[] res = timePlanner(slotsA, slotsB, duration);
		System.out.println(res[0] + " " + res[1]);
	}

	private static int[] timePlanner(int[][] slotsA, int[][] slotsB, int duration) {
		int slotAP = 0;
		int slotBP = 0;
		int[] result = new int[2];
		while (slotAP < slotsA.length && slotBP < slotsB.length) {
			if (overlap(slotsA[slotAP], slotsB[slotBP], duration)) {
				result[0] = slotsA[slotAP][0];
				result[1] = result[0] + duration;
				return result;
			}
			if (slotsA[slotAP][0] > slotsB[slotBP][0])
				slotBP++;
			else
				slotAP++;
		}
		return null;
	}

	private static boolean overlap(int[] slotA, int[] slotB, int duration) {
		int timeRange = Math.min(slotA[1], slotB[1])- Math.max(slotA[0], slotB[0]);
		if (timeRange >= duration) {
			return true;
		}
		return false;
	}
}
