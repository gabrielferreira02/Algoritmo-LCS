public class AlgoritmoLCS {
    public static void main(String[] args) {
        String a = "ABCBDAB";
        String b = "BDCAB";
        long inicio = System.nanoTime();
        int res = lcs(a, b);
        long fim = System.nanoTime();
        System.out.println("Maior subsequencia comum: " + res);
        double tempoExecucao = (fim - inicio) / 1_000_000.0;
        System.out.println("Executado em: " + tempoExecucao + "ms");
    }

    public static int lcs(String a, String b) {
        int[][] v = new int[a.length() + 1][b.length() + 1];

        for(int i = 1; i <= a.length(); i++) {
            for(int j = 1; j <= b.length(); j++) {
                if(a.charAt(i - 1) == b.charAt(j - 1)) {
                    v[i][j] = v[i - 1][j - 1] + 1;
                } else {
                    v[i][j] = Math.max(v[i - 1][j], v[i][j - 1]);
                }
            }
        }

        return v[a.length()][b.length()];
    }
}
