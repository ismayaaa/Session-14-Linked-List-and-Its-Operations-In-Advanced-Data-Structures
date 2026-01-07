public class MainDLLSlow {                                                     // nama class = nama file

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

    static class DoublyLinkedListSlow {                                        // implementasi doubly linked list (slow)
        private Node head;                                                     // hanya simpan head

        public void addFirst(int value) {                                      // tambah di depan
            Node n = new Node(value);                                          // buat node baru
            if (head == null) {                                                // jika list kosong
                head = n;                                                      // head menunjuk node baru
                return;                                                        // selesai
            }                                                                  // akhir if
            n.next = head;                                                     // node baru menunjuk head lama
            head.prev = n;                                                     // head lama menunjuk balik node baru
            head = n;                                                          // update head
        }                                                                      // akhir addFirst

        public void addLast(int value) {                                       // tambah di belakang (traversal)
            Node n = new Node(value);                                          // buat node baru
            if (head == null) {                                                // jika list kosong
                head = n;                                                      // node baru jadi head
                return;                                                        // selesai
            }                                                                  // akhir if
            Node cur = head;                                                   // mulai dari head
            while (cur.next != null) {                                         // cari node terakhir
                cur = cur.next;                                                // maju satu node
            }                                                                  // akhir while
            cur.next = n;                                                      // sambungkan tail ke node baru
            n.prev = cur;                                                      // node baru menunjuk balik tail lama
        }                                                                      // akhir addLast

        public boolean remove(int value) {                                     // hapus node berdasarkan nilai
            Node cur = head;                                                   // mulai dari head
            while (cur != null && cur.data != value) {                         // cari node dengan data = value
                cur = cur.next;                                                // maju
            }                                                                  // akhir while
            if (cur == null) return false;                                     // jika tidak ketemu, gagal hapus

            if (cur.prev != null) cur.prev.next = cur.next;                    // sambungkan prev ke next (lewati cur)
            else head = cur.next;                                              // jika cur adalah head, geser head

            if (cur.next != null) cur.next.prev = cur.prev;                    // sambungkan next ke prev
            return true;                                                       // hapus berhasil
        }                                                                      // akhir remove

        public void displayForward() {                                         // tampilkan dari head ke tail
            Node cur = head;                                                   // mulai dari head
            while (cur != null) {                                              // selama masih ada node
                System.out.print(cur.data);                                    // cetak data
                System.out.print(cur.next != null ? " <-> " : " <-> null\n");  // panah / akhir
                cur = cur.next;                                                // maju
            }                                                                  // akhir while
        }                                                                      // akhir displayForward

        public void displayBackward() {                                        // tampilkan dari tail ke head (traversal dulu)
            if (head == null) {                                                // jika kosong
                System.out.println("null");                                    // tampilkan null
                return;                                                        // selesai
            }                                                                  // akhir if
            Node cur = head;                                                   // mulai dari head
            while (cur.next != null) {                                         // cari tail dengan traversal
                cur = cur.next;                                                // maju sampai tail
            }                                                                  // akhir while
            while (cur != null) {                                              // mundur menggunakan prev
                System.out.print(cur.data);                                    // cetak data
                System.out.print(cur.prev != null ? " <-> " : " <-> null\n");  // panah / akhir
                cur = cur.prev;                                                // mundur
            }                                                                  // akhir while
        }                                                                      // akhir displayBackward
    }                                                                          // akhir DoublyLinkedListSlow

    public static void main(String[] args) {                                   // main untuk uji coba
        DoublyLinkedListSlow dll = new DoublyLinkedListSlow();                 // buat list
        dll.addFirst(20);                                                      // tambah depan
        dll.addFirst(10);                                                      // tambah depan
        dll.addLast(30);                                                       // tambah belakang (traversal)
        dll.addLast(40);                                                       // tambah belakang (traversal)
        dll.displayForward();                                                  // tampilkan maju
        dll.displayBackward();                                                 // tampilkan mundur (cari tail dulu)
        dll.remove(30);                                                        // hapus nilai 30
        dll.displayForward();                                                  // tampilkan setelah hapus
    }                                                                          // akhir main
}                                                                              // akhir program
