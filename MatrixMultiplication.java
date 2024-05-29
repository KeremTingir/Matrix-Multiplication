public class MatrixMultiplication{
    public static void main(String[] args) {
        // Kullanıcıdan matris boyutları ve iş parçacığı sayısını al
        int matrixSize = 5; // Matris boyutları
        int threadCount = 5; // İş parçacığı sayısı

        // Matrisleri oluştur
        Matrix matrixA = new Matrix(matrixSize);
        Matrix matrixB = new Matrix(matrixSize);

        // Matris A  !!!
        System.out.println("Matris A:");
        matrixA.print();

        // Matris B  !!!
        System.out.println("Matris B:");
        matrixB.print();


        // Sonuç matrisi oluştur  !!!
        System.out.println("Result:");
        Matrix resultMatrix = new Matrix(matrixSize);

        // İş parçacıklarını başlat
        MatrixWorker[] workers = new MatrixWorker[threadCount];
        for (int i = 0; i < threadCount; i++) {
            workers[i] = new MatrixWorker(matrixA, matrixB, resultMatrix);
            workers[i].start();
        }

        // İş parçacıklarının tamamlanmasını bekle
        for (MatrixWorker worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Sonucu yazdır
        resultMatrix.print();
    }
}
