
class Solution {
    public boolean makesquare(int[] matchsticks) {

        int total = 0;
        int len = matchsticks.length;
        for (int i = 0; i < len; i++) {
            total += matchsticks[i];
        }

        if (total % 4 != 0)
            return false;

        int side = total / 4;
        for (int i = 0; i < len; i++) {
            if (matchsticks[i] > side)
                return false;
        }

        Arrays.sort(matchsticks);
        reverse(matchsticks); // to reduce TC check bigger sticks first
        return bactrack(matchsticks, 0, new int[4], side);

    }

    private boolean bactrack(int[] matchsticks, int idx, int[] square, int side) {
        // base
        if (idx == matchsticks.length) {
            if (square[0] == side && square[1] == side && square[2] == side)
                return true;
            else
                return false;
        }
        // logic
        for (int i = 0; i < 4; i++) {
            if (matchsticks[idx] + square[i] <= side) {
                // action
                square[i] += matchsticks[idx];
                // recurse
                if (bactrack(matchsticks, idx + 1, square, side))
                    return true;

                square[i] -= matchsticks[idx];
            }
        }

        return false;

    }

    private void reverse(int[] matchsticks) {
        int left = 0;
        int right = matchsticks.length - 1;
        while (left < right) {
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;
            left++;
            right--;
        }
    }
}