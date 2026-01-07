public class MainFast {                                                        // nama class = nama file

    static class Node {                                                        // definisi node doubly linked list
        int data;                                                              // menyimpan nilai
        Node prev;                                                             // pointer ke node sebelumnya
        Node next;                                                             // pointer ke node berikutnya

        Node(int data) {                                                       // konstruktor node
            this.data = data;                                                  // set nilai data
            this.prev = null;                                                  // prev awal null
            this.next = null;                                                  // next awal null
        }                                                                      // akhir konstruktor
    }                                                                          // akhir class Node

    static class DoublyListFast {                                              // list versi cepat (dengan tail)
        private Node head;                                                     // pointer node pertama
        private Node tail;                                                     // pointer node terakhir
        private int size;                                                      // jumlah elemen (opsional)

        public void pushFront(int value) {                                     // push di depan (O(1))
            Node n = new Node(value);                                          // buat node baru
            if (head == null) {                                                // jika kosong
                head = tail = n;                                               // head dan tail sama
            } else {                                                            // jika ada isi
                n.next = head;                                                 // node baru menunjuk head lama
                head.prev = n;                                                 // head lama menunjuk balik node baru
                head = n;                                                      // update head
            }                                                                   // akhir else
            size++;                                                             // size bertambah
        }                                                                       // akhir pushFront

        public void pushBack(int value) {                                      // push di belakang (O(1))
            Node n = new Node(value);                                          // buat node baru
            if (tail == null) {                                                // jika kosong
                head = tail = n;                                               // head dan tail sama
            } else {                                                            // jika ada isi
                tail.next = n;                                                 // tail lama menunjuk node baru
                n.prev = tail;                                                 // node baru menunjuk balik tail lama
                tail = n;                                                      // update tail
            }                                                                   // akhir else
            size++;                                                             // size bertambah
        }                                                                       // akhir pushBack

        public Integer popFront() {                                            // pop dari depan (O(1))
            if (head == null) return null;                                     // jika kosong
            int removed = head.data;                                           // simpan data head
            if (head == tail) {                                                // jika 1 node
                head = tail = null;                                            // list jadi kosong
            } else {                                                            // jika >1 node
                head = head.next;                                              // geser head
                head.prev = null;                                              // putus prev head baru
            }                                                                   // akhir else
            size--;                                                             // size berkurang
            return removed;                                                    // kembalikan data
        }                                                                       // akhir popFront

        public Integer popBack() {                                             // pop dari belakang (O(1))
            if (tail == null) return null;                                     // jika kosong
            int removed = tail.data;                                           // simpan data tail
            if (head == tail) {                                                // jika 1 node
                head = tail = null;                                            // list jadi kosong
            } else {                                                            // jika >1 node
                tail = tail.prev;                                              // geser tail ke node sebelumnya
                tail.next = null;                                              // putus next tail baru
            }                                                                   // akhir else
            size--;                                                             // size berkurang
            return removed;                                                    // kembalikan data
        }                                                                       // akhir popBack

        public void print() {                                                  // tampilkan isi list
            Node cur = head;                                                   // mulai dari head
            while (cur != null) {                                              // selama masih ada node
                System.out.print(cur.data);                                    // cetak data
                System.out.print(cur.next != null ? " <-> " : " <-> null\n");  // cetak pemisah/akhir
                cur = cur.next;                                                // maju
            }                                                                  // akhir while
        }                                                                      // akhir print

        public int size() {                                                    // method ukuran list
            return size;                                                       // kembalikan size
        }                                                                      // akhir size
    }                                                                          // akhir class DoublyListFast

    public static void main(String[] args) {                                   // titik masuk program
        DoublyListFast list = new DoublyListFast();                            // buat list versi cepat
        list.pushFront(20);                                                    // tambah depan
        list.pushFront(10);                                                    // tambah depan
        list.pushBack(30);                                                     // tambah belakang (tanpa traversal)
        list.pushBack(40);                                                     // tambah belakang (tanpa traversal)
        list.print();                                                          // tampilkan list
        System.out.println("popBack = " + list.popBack());                     // hapus belakang (O(1))
        System.out.println("popFront = " + list.popFront());                   // hapus depan (O(1))
        list.print();                                                          // tampilkan lagi
        System.out.println("size = " + list.size());                           // tampilkan ukuran
    }                                                                          // akhir main
}                                                                              // akhir program
