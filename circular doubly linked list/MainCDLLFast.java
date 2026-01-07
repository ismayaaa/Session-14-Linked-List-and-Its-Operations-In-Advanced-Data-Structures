public class MainCDLLFast {                                                    // nama class = nama file

    static class Node {                                                        // node circular doubly linked list
        int data;                                                              // nilai yang disimpan
        Node prev;                                                             // pointer ke node sebelumnya
        Node next;                                                             // pointer ke node berikutnya

        Node(int data) {                                                       // konstruktor node
            this.data = data;                                                  // isi data
            this.prev = this;                                                  // default self-loop
            this.next = this;                                                  // default self-loop
        }                                                                      // akhir konstruktor
    }                                                                          // akhir Node

    static class CircularDoublyListFast {                                      // CDLL versi lebih baik
        private Node head;                                                     // pointer node pertama
        private Node tail;                                                     // pointer node terakhir (akses eksplisit)
        private int size;                                                      // jumlah node

        public void addFirst(int value) {                                      // tambah di depan (O(1))
            Node n = new Node(value);                                          // buat node baru
            if (head == null) {                                                // jika kosong
                head = tail = n;                                               // head dan tail sama
            } else {                                                            // jika ada isi
                n.next = head;                                                 // node baru ke head lama
                n.prev = tail;                                                 // node baru ke tail
                head.prev = n;                                                 // head lama prev ke node baru
                tail.next = n;                                                 // tail next ke node baru
                head = n;                                                      // update head
            }                                                                   // akhir else
            size++;                                                             // size bertambah
        }                                                                       // akhir addFirst

        public void addLast(int value) {                                       // tambah di belakang (O(1))
            Node n = new Node(value);                                          // buat node baru
            if (tail == null) {                                                // jika kosong
                head = tail = n;                                               // head dan tail sama
            } else {                                                            // jika ada isi
                n.prev = tail;                                                 // node baru prev ke tail lama
                n.next = head;                                                 // node baru next ke head
                tail.next = n;                                                 // tail lama next ke node baru
                head.prev = n;                                                 // head prev ke node baru (tail baru)
                tail = n;                                                      // update tail
            }                                                                   // akhir else
            size++;                                                             // size bertambah
        }                                                                       // akhir addLast

        public Integer removeFirst() {                                         // hapus dari depan (O(1))
            if (head == null) return null;                                     // jika kosong
            int removed = head.data;                                           // simpan data head
            if (size == 1) {                                                   // jika hanya satu node
                head = tail = null;                                            // list kosong
            } else {                                                            // jika lebih dari satu
                head = head.next;                                              // geser head ke depan
                head.prev = tail;                                              // perbaiki prev head ke tail
                tail.next = head;                                              // perbaiki next tail ke head
            }                                                                   // akhir else
            size--;                                                             // size berkurang
            return removed;                                                    // kembalikan data
        }                                                                       // akhir removeFirst

        public Integer removeLast() {                                          // hapus dari belakang (O(1))
            if (tail == null) return null;                                     // jika kosong
            int removed = tail.data;                                           // simpan data tail
            if (size == 1) {                                                   // jika hanya satu node
                head = tail = null;                                            // list kosong
            } else {                                                            // jika lebih dari satu
                tail = tail.prev;                                              // geser tail mundur
                tail.next = head;                                              // perbaiki next tail ke head
                head.prev = tail;                                              // perbaiki prev head ke tail
            }                                                                   // akhir else
            size--;                                                             // size berkurang
            return removed;                                                    // kembalikan data
        }                                                                       // akhir removeLast

        public boolean removeValue(int value) {                                // hapus berdasarkan nilai (O(n))
            if (head == null) return false;                                    // jika kosong
            Node cur = head;                                                   // mulai dari head
            do {                                                               // loop satu putaran
                if (cur.data == value) {                                       // jika ketemu target
                    if (size == 1) {                                           // jika hanya satu node
                        head = tail = null;                                    // list kosong
                    } else if (cur == head) {                                   // jika node adalah head
                        removeFirst();                                         // delegasi ke removeFirst
                    } else if (cur == tail) {                                   // jika node adalah tail
                        removeLast();                                          // delegasi ke removeLast
                    } else {                                                    // jika node di tengah
                        cur.prev.next = cur.next;                              // lewati node dari sisi prev
                        cur.next.prev = cur.prev;                              // lewati node dari sisi next
                        size--;                                                // size berkurang
                    }                                                           // akhir else tengah
                    return true;                                               // berhasil hapus
                }                                                              // akhir if ketemu
                cur = cur.next;                                                // maju
            } while (cur != head);                                             // stop saat kembali ke head
            return false;                                                      // tidak ditemukan
        }                                                                       // akhir removeValue

        public void displayForward() {                                         // tampilkan maju
            if (head == null) {                                                // jika kosong
                System.out.println("empty");                                   // tampilkan empty
                return;                                                        // selesai
            }                                                                  // akhir if
            Node cur = head;                                                   // mulai dari head
            do {                                                               // loop satu putaran
                System.out.print(cur.data + " <-> ");                          // cetak data
                cur = cur.next;                                                // maju
            } while (cur != head);                                             // stop saat balik ke head
            System.out.println("(back to head)");                              // penanda circular
        }                                                                       // akhir displayForward

        public void displayBackward() {                                        // tampilkan mundur
            if (tail == null) {                                                // jika kosong
                System.out.println("empty");                                   // tampilkan empty
                return;                                                        // selesai
            }                                                                  // akhir if
            Node cur = tail;                                                   // mulai dari tail langsung
            do {                                                               // loop satu putaran
                System.out.print(cur.data + " <-> ");                          // cetak data
                cur = cur.prev;                                                // mundur
            } while (cur != tail);                                             // stop saat balik ke tail
            System.out.println("(back to tail)");                              // penanda circular
        }                                                                       // akhir displayBackward

        public int size() {                                                    // method ukuran
            return size;                                                       // kembalikan size
        }                                                                       // akhir size
    }                                                                          // akhir class CircularDoublyListFast

    public static void main(String[] args) {                                   // main untuk uji coba
        CircularDoublyListFast cdll = new CircularDoublyListFast();            // buat CDLL
        cdll.addFirst(20);                                                     // tambah depan
        cdll.addFirst(10);                                                     // tambah depan
        cdll.addLast(30);                                                      // tambah belakang
        cdll.addLast(40);                                                      // tambah belakang
        cdll.displayForward();                                                 // tampilkan maju
        cdll.displayBackward();                                                // tampilkan mundur
        System.out.println("removeFirst = " + cdll.removeFirst());             // hapus depan
        System.out.println("removeLast  = " + cdll.removeLast());              // hapus belakang
        cdll.displayForward();                                                 // tampilkan lagi
        System.out.println("size = " + cdll.size());                           // tampilkan size
    }                                                                          // akhir main
}                                                                              // akhir program
