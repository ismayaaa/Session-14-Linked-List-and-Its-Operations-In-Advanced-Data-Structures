public class MainCDLLSlow {                                                    // nama class = nama file

    static class Node {                                                        // node circular doubly linked list
        int data;                                                              // nilai yang disimpan
        Node prev;                                                             // pointer ke node sebelumnya
        Node next;                                                             // pointer ke node berikutnya

        Node(int data) {                                                       // konstruktor node
            this.data = data;                                                  // isi data
            this.prev = this;                                                  // default: menunjuk diri sendiri (circular)
            this.next = this;                                                  // default: menunjuk diri sendiri (circular)
        }                                                                      // akhir konstruktor
    }                                                                          // akhir class Node

    static class CircularDoublyListSlow {                                      // CDLL versi lambat
        private Node head;                                                     // hanya simpan head

        public void addFirst(int value) {                                      // tambah di depan
            Node n = new Node(value);                                          // buat node baru (sudah self-loop)
            if (head == null) {                                                // jika list kosong
                head = n;                                                      // head menunjuk node baru
                return;                                                        // selesai
            }                                                                  // akhir if
            Node tail = head.prev;                                             // tail diperoleh dari head.prev
            n.next = head;                                                     // node baru menunjuk head lama
            n.prev = tail;                                                     // node baru menunjuk tail
            tail.next = n;                                                     // tail menunjuk node baru
            head.prev = n;                                                     // head lama menunjuk balik ke node baru
            head = n;                                                          // update head
        }                                                                      // akhir addFirst

        public void addLast(int value) {                                       // tambah di belakang
            Node n = new Node(value);                                          // buat node baru
            if (head == null) {                                                // jika list kosong
                head = n;                                                      // head menunjuk node baru
                return;                                                        // selesai
            }                                                                  // akhir if
            Node tail = head.prev;                                             // tail didapat dari head.prev
            n.next = head;                                                     // node baru menunjuk head (circular)
            n.prev = tail;                                                     // node baru menunjuk tail lama
            tail.next = n;                                                     // tail lama menunjuk node baru
            head.prev = n;                                                     // head menunjuk balik ke node baru (jadi tail baru)
        }                                                                      // akhir addLast

        public boolean remove(int value) {                                     // hapus node berdasarkan nilai
            if (head == null) return false;                                    // jika kosong, gagal
            Node cur = head;                                                   // mulai dari head
            do {                                                               // loop minimal sekali (circular)
                if (cur.data == value) {                                       // jika node ditemukan
                    if (cur.next == cur) {                                     // jika hanya satu node
                        head = null;                                           // list jadi kosong
                    } else {                                                    // jika lebih dari satu node
                        cur.prev.next = cur.next;                              // lewati cur dari arah prev->next
                        cur.next.prev = cur.prev;                              // lewati cur dari arah next->prev
                        if (cur == head) head = cur.next;                      // jika yang dihapus head, geser head
                    }                                                           // akhir else
                    return true;                                               // berhasil hapus
                }                                                              // akhir if cocok
                cur = cur.next;                                                // maju ke node berikutnya
            } while (cur != head);                                             // berhenti saat kembali ke head
            return false;                                                      // jika tidak ditemukan
        }                                                                      // akhir remove

        public void displayForward() {                                         // tampilkan searah jarum jam
            if (head == null) {                                                // jika kosong
                System.out.println("empty");                                   // tampilkan empty
                return;                                                        // selesai
            }                                                                  // akhir if
            Node cur = head;                                                   // mulai dari head
            do {                                                               // loop satu putaran
                System.out.print(cur.data + " <-> ");                          // cetak data
                cur = cur.next;                                                // maju
            } while (cur != head);                                             // stop saat kembali ke head
            System.out.println("(back to head)");                              // penanda circular
        }                                                                      // akhir displayForward

        public void displayBackward() {                                        // tampilkan berlawanan arah
            if (head == null) {                                                // jika kosong
                System.out.println("empty");                                   // tampilkan empty
                return;                                                        // selesai
            }                                                                  // akhir if
            Node cur = head.prev;                                              // mulai dari tail via head.prev
            do {                                                               // loop satu putaran
                System.out.print(cur.data + " <-> ");                          // cetak data
                cur = cur.prev;                                                // mundur
            } while (cur != head.prev);                                        // stop saat kembali ke tail awal
            System.out.println("(back to tail)");                              // penanda circular
        }                                                                      // akhir displayBackward
    }                                                                          // akhir class CircularDoublyListSlow

    public static void main(String[] args) {                                   // main untuk uji coba
        CircularDoublyListSlow cdll = new CircularDoublyListSlow();            // buat CDLL
        cdll.addFirst(20);                                                     // tambah depan
        cdll.addFirst(10);                                                     // tambah depan
        cdll.addLast(30);                                                      // tambah belakang
        cdll.addLast(40);                                                      // tambah belakang
        cdll.displayForward();                                                 // tampilkan maju
        cdll.displayBackward();                                                // tampilkan mundur
        cdll.remove(10);                                                       // hapus 10
        cdll.displayForward();                                                 // tampilkan lagi
    }                                                                          // akhir main
}                                                                              // akhir program
