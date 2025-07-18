class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()){
            return new ArrayList<>();
        }
        return pad("", digits);
    }

    public List<String> pad(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int d = up.charAt(0) - '0';
        int i = (d - 2) * 3;
        if (d > 7) {
            i += 1;
        }
        int len = i + 3;
        if (d == 7 || d == 9) {
            len += 1;
        }
        ArrayList<String> list = new ArrayList<>();
        for (; i < len; i++) {
            char ch = (char) ('a' + i);
            list.addAll(pad(p + ch, up.substring(1)));
        }
        return list;
    }

}