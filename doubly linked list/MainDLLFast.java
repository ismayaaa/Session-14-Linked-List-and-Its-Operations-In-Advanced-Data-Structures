public class MainDLLFast {                                                     // nama class = nama file

    static class Node {                                                        // node doubly linked list
        int data;                                                              // nilai yang disimpan
        Node prev;                                                             // pointer ke node sebelumnya
        Node next;                                                             // pointer ke node berikutnya

        Node(int data) {                                                       // konstruktor node
            this.data = data;                                                  // isi data node
            this.prev = null;                                                  // prev awal null
            this.next = null;                                                  // next awal null
        }                                                                      // akhir konstruktor
    }                                                                          // akhir Node

    static class DoublyLinkedListFast {                                        // implementasi doubly linked list (fast)
        private Node head;                                                     // pointer node pertama
        private Node tail;                                                     // pointer node terakhir
        private int size;                                                      // jumlah node (opsional)

        public void addFirst(int value) {                                      // tambah di depan (O(1))
            Node n = new Node(value);                                          // buat node baru
            if (head == null) {                                                // jika list kosong
                head = tail = n;                                               // head dan tail sama
            } else {                                                            // jika list ada isi
                n.next = head;                                                 // node baru menunjuk head lama
                head.prev = n;                                                 // head lama menunjuk balik node baru
                head = n;                                                      // update head
            }                                                                   // akhir else
            size++;                                                             // size bertambah
        }                                                                       // akhir addFirst

        public void addLast(int value) {                                       // tambah di belakang (O(1))
            Node n = new Node(value);                                          // buat node baru
            if (tail == null) {                                                // jika list kosong
                head = tail = n;                                               // head dan tail sama
            } else {                                                            // jika list ada isi
                tail.next = n;                                                 // tail lama menunjuk node baru
                n.prev = tail;                                                 // node baru menunjuk balik tail lama
                tail = n;                                                      // update tail
            }                                                                   // akhir else
            size++;                                                             // size bertambah
        }                                                                       // akhir addLast

        public boolean remove(int value) {                                     // hapus node berdasarkan nilai
            Node cur = head;                                                   // mulai dari head
            while (cur != null && cur.data != value) {                         // cari node target
                cur = cur.next;                                                // maju
            }                                                                  // akhir while
            if (cur == null) return false;                                     // jika tidak ditemukan

            if (cur == head) {                                                 // jika yang dihapus adalah head
                head = cur.next;                                               // geser head
                if (head != null) head.prev = null;                            // putus prev head baru
                else tail = null;                                              // jika list jadi kosong, tail null
            } else if (cur == tail) {                                          // jika yang dihapus adalah tail
                tail = cur.prev;                                               // geser tail
                tail.next = null;                                              // putus next tail baru
            } else {                                                            // jika di tengah
                cur.prev.next = cur.next;                                      // sambungkan prev ke next
                cur.next.prev = cur.prev;                                      // sambungkan next ke prev
            }                                                                   // akhir else
            size--;                                                             // size berkurang
            return true;                                                       // hapus berhasil
        }                                                                       // akhir remove

        public void displayForward() {                                         // tampilkan dari head ke tail
            Node cur = head;                                                   // mulai dari head
            while (cur != null) {                                              // selama masih ada node
                System.out.print(cur.data);                                    // cetak data
                System.out.print(cur.next != null ? " <-> " : " <-> null\n");  // panah / akhir
                cur = cur.next;                                                // maju
            }                                                                  // akhir while
        }                                                                       // akhir displayForward

        public void displayBackward() {                                        // tampilkan dari tail ke head (O(n) untuk cetak)
            Node cur = tail;                                                   // mulai dari tail (tanpa cari tail)
            while (cur != null) {                                              // selama masih ada node
                System.out.print(cur.data);                                    // cetak data
                System.out.print(cur.prev != null ? " <-> " : " <-> null\n");  // panah / akhir
                cur = cur.prev;                                                // mundur
            }                                                                  // akhir while
        }                                                                       // akhir displayBackward

        public int size() {                                                    // method ukuran list
            return size;                                                       // kembalikan size
        }                                                                       // akhir size
    }                                                                          // akhir DoublyLinkedListFast

    public static void main(String[] args) {                                   // main untuk uji coba
        DoublyLinkedListFast dll = new DoublyLinkedListFast();                 // buat list
        dll.addFirst(20);                                                      // tambah depan
        dll.addFirst(10);                                                      // tambah depan
        dll.addLast(30);                                                       // tambah belakang O(1)
        dll.addLast(40);                                                       // tambah belakang O(1)
        dll.displayForward();                                                  // tampilkan maju
        dll.displayBackward();                                                 // tampilkan mundur tanpa cari tail
        dll.remove(30);                                                        // hapus nilai 30
        dll.displayForward();                                                  // tampilkan setelah hapus
        System.out.println("size = " + dll.size());                            // tampilkan ukuran
    }                                                                          // akhir main
}                                                                              // akhir program
