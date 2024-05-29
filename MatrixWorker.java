public class MatrixWorker extends Thread {
    private Matrix matrixA;
    private Matrix matrixB;
    private Matrix resultMatrix;

    public MatrixWorker(Matrix a, Matrix b, Matrix result) {
        this.matrixA = a;
        this.matrixB = b;
        this.resultMatrix = result;
    }

    @Override
    public void run() {
        int size = matrixA.getSize();
        int startRow = 0; // Başlangıç satırı
        int endRow = size; // Bitiş satırı

        // Her iş parçacığı, matrisin boyutuna göre bir aralıktaki satırları hesaplar
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += matrixA.getElement(i, k) * matrixB.getElement(k, j);
                }
                // Hesaplanan değeri sonuç matrisine kaydet
                resultMatrix.setElement(i, j, sum);
            }
        }
    }
}
