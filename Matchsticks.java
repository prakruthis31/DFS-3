/* TC 5^k, k is height of the tree (k = number of digits in n)
*/
class Solution {
    int count;
    Map<Integer, Integer> map;

    public int confusingNumberII(int n) {
        this.count = 0;
        this.map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        dfs(0l, n);

        return count;
    }

    private void dfs(long curr, int n) {
        // base
        if (curr > n)
            return;

        // logic
        if (isConfusing(curr)) {
            count++;
        }

        for (int digit : map.keySet()) {
            long newnum = curr * 10 + digit;
            if (newnum != 0) {
                dfs(newnum, n);
            }

        }
    }

    private boolean isConfusing(long curr) { // reverse digit
        long temp = curr;
        long result = 0l;
        while (temp > 0) {
            int digit = (int) temp % 10;
            result = result * 10 + map.get(digit);
            temp = temp / 10;
        }

        return result != curr;
    }
}