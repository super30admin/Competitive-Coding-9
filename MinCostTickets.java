class MinCostTickets {
    public int mincostTickets(int[] days, int[] costs) {

        int[] arr = new int[days[days.length - 1] + 1];

        arr[0] = 0;

        Set<Integer> setOfDays = new HashSet<>();

        for (int i=0; i<days.length; i++) {
            setOfDays.add(days[i]);
        }

        for (int i=1; i<arr.length; i++) {

            if (setOfDays.contains(i)) {

                int min = Integer.MAX_VALUE;

                for (int j=0; j<costs.length; j++) {

                    int index = Math.max(i - costs[j], 0);
                    int cost = arr[index] + costs[j];
                    min = Math.min(cost, min);
                    arr[i] = min;
                }

            } else {
                arr[i] = arr[i - 1];
            }


        }

        return arr[arr.length - 1];

    }
}