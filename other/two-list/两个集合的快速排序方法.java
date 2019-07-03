
    /**
     * 快速排序算法
     *
     * @param dataList  排序的集合
     * @param indexList 辅助索引集合
     **/
    public void quickSort(List<Integer> dataList, List<Integer> indexList) {
        sort(dataList, 0, dataList.size() - 1, indexList);
    }

    private void sort(List<Integer> dataList, int low, int hight, List<Integer> indexList) {
        int i, j, index, tempIndex;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        // 用子表的第一个记录做基准
        index = dataList.get(i);
        tempIndex = indexList.get(i);
        while (i < j) {
            while (i < j && dataList.get(j) >= index) {
                j--;
            }
            if (i < j) {
                dataList.set(i, dataList.get(j));
                indexList.set(i, indexList.get(j));
                i++;
            }
            while (i < j && dataList.get(i) < index) {
                i++;
            }
            if (i < j) {
                dataList.set(j, dataList.get(i));
                indexList.set(j, indexList.get(i));
                j--;
            }
        }
        dataList.set(i, index);
        indexList.set(i, tempIndex);
        sort(dataList, low, i - 1, indexList);
        sort(dataList, i + 1, hight, indexList);
    }
