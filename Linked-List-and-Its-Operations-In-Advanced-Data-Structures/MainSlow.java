public class MainSlow {                                                        // nama class = nama file

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

    static class DoublyListSlow {                                              // list versi lambat (tanpa tail)
        private Node head;                                                     // hanya simpan head

        public void pushFront(int value) {                                     // push di depan
            Node n = new Node(value);                                          // buat node baru
            if (head == null) {                                                // jika kosong
                head = n;                                                      // head jadi node baru
                return;                                                        // selesai
            }                                                                  // akhir if
            n.next = head;                                                     // node baru menunjuk head lama
            head.prev = n;                                                     // head lama menunjuk balik ke node baru
            head = n;                                                          // update head
        }                                                                      // akhir pushFront

        public void pushBack(int value) {                                      // push di belakang (butuh traversal)
            Node n = new Node(value);                                          // buat node baru
            if (head == null) {                                                // jika kosong
                head = n;                                                      // head jadi node baru
                return;                                                        // selesai
            }                                                                  // akhir if
            Node cur = head;                                                   // mulai dari head
            while (cur.next != null) {                                         // cari node terakhir
                cur = cur.next;                                                // maju satu node
            }                                                                  // akhir while
            cur.next = n;                                                      // sambungkan tail ke node baru
            n.prev = cur;                                                      // node baru menunjuk balik ke tail lama
        }                                                                      // akhir pushBack

        public Integer popFront() {                                            // pop dari depan
            if (head == null) return null;                                     // jika kosong, tidak ada yang dihapus
            int removed = head.data;                                           // simpan data head
            head = head.next;                                                  // geser head
            if (head != null) head.prev = null;                                // putus prev pada head baru
            return removed;                                                    // kembalikan nilai yang dihapus
        }                                                                      // akhir popFront

        public Integer popBack() {                                             // pop dari belakang (butuh traversal)
            if (head == null) return null;                                     // jika kosong
            if (head.next == null) {                                           // jika hanya satu node
                int removed = head.data;                                       // simpan datanya
                head = null;                                                   // list jadi kosong
                return removed;                                                // kembalikan data
            }                                                                  // akhir if satu node
            Node cur = head;                                                   // mulai dari head
            while (cur.next != null) {                                         // cari node terakhir
                cur = cur.next;                                                // maju sampai tail
            }                                                                  // akhir while
            int removed = cur.data;                                            // simpan data tail
            cur.prev.next = null;                                              // putuskan hubungan node sebelum tail
            return removed;                                                    // kembalikan data
        }                                                                      // akhir popBack

        public void print() {                                                  // tampilkan isi list
            Node cur = head;                                                   // mulai dari head
            while (cur != null) {                                              // selama masih ada node
                System.out.print(cur.data);                                    // cetak data
                System.out.print(cur.next != null ? " <-> " : " <-> null\n");  // cetak pemisah/akhir
                cur = cur.next;                                                // maju
            }                                                                  // akhir while
        }                                                                      // akhir print
    }                                                                          // akhir class DoublyListSlow

    public static void main(String[] args) {                                   // titik masuk program
        DoublyListSlow list = new DoublyListSlow();                            // buat list versi lambat
        list.pushFront(20);                                                    // tambah depan
        list.pushFront(10);                                                    // tambah depan
        list.pushBack(30);                                                     // tambah belakang (traversal)
        list.pushBack(40);                                                     // tambah belakang (traversal)
        list.print();                                                          // tampilkan list
        System.out.println("popBack = " + list.popBack());                     // hapus belakang (traversal)
        System.out.println("popFront = " + list.popFront());                   // hapus depan
        list.print();                                                          // tampilkan lagi
    }                                                                          // akhir main
}                                                                              // akhir program
