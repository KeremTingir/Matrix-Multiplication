import java.util.Random;
public class Matrix{
    private int[][] data;

    // Belirtilen boyutta rastgele matris oluştur
    public Matrix(int size) {
        this.data = new int[size][size];
        initializeRandom();
    }

    private void initializeRandom(){
        Random random = new Random();
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                data[i][j] = random.nextInt(100);//Rastgele sayılar 0 ile 99 arasında
            }
        }
    }

    // Matris boyutunu döndür
    public int getSize() {
        return data.length;
    }

    // Matrisin belirli bir elemanını döndür
    public int getElement(int row, int col) {
        return data[row][col];
    }

    // Matrisin belirli bir elemanını ayarla
    public void setElement(int row, int col, int value) {
        data[row][col] = value;
    }

    // Matrisi ekrana yazdır
    public void print() {
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++){
                System.out.print(data[i][j] + "\t");//Her eleman arasına tab ekleyerek yazdır
            }
            System.out.println();//Her satırın sonuna yeni satıra geç
        }
    }
}
