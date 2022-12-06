import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int size) {
        this.maxsize = size;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void downHeapify(int pos) {
        if (pos >= (size / 2) && pos <= size)
            return;

        if (Heap[pos] < Heap[leftChild(pos)] ||
                Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                downHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                downHeapify(rightChild(pos));
            }
        }
    }

    private void heapifyUp(int pos) {
        int temp = Heap[pos];
        while (pos > 0 && temp > Heap[parent(pos)]) {
            Heap[pos] = Heap[parent(pos)];
            pos = parent(pos);
        }
        Heap[pos] = temp;
    }

    public void insert(int element) {
        Heap[++size] = element;

        int current = size;
        heapifyUp(current);

    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(+Heap[i] + ": L- " +
                    Heap[2 * i] + " R- " + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public int extractMax() {
        int max = Heap[1];
        Heap[1] = Heap[size--];
        downHeapify(1);
        return max;
    }
}

 class bptreeone {
    Scanner input = new Scanner(System.in);

    public class bpnode {
        int[] data;
        int i;
        bpnode[] childpointer;
        bpnode[] parentpointer;
        bpnode[] next;

        bpnode(int order) {
            this.i = 0;
            this.data = new int[order];
            this.childpointer = new bpnode[order + 2];
            this.parentpointer = new bpnode[1];
            this.next = new bpnode[1];
            next[0] = null;
            parentpointer[0] = null;
        }
    }

    int countnode = 0;

    bpnode head = new bpnode(1);
    bpnode root = new bpnode(1);

    public void insertdatainaninternalnode(bpnode z, bpnode y, int order, int key) {
        System.out.println("workinf");
        if (z.i == order - 1) {
            System.out.println("workinf");
            if (z.parentpointer[0] == null) {
                System.out.println("workinf");
                z.data[order - 1] = key;
                z.childpointer[order] = y;
                sort(z, order);
                z.i++;
                bpnode x = new bpnode(order);
                bpnode xx = new bpnode(order);

                root.next[0] = xx;
                int k = order;
                if (k % 2 == 0) {
                    int r = k / 2;
                    xx.data[0] = z.data[(order) / 2];
                    for (int i = 0; i < r - 1; i++) {
                        x.data[i] = z.data[1 + (i + (order / 2))];
                        z.i--;
                        x.i++;
                        x.childpointer[i + 1] = z.childpointer[2 + (i + (order / 2))];
                    }
                    x.childpointer[0] = z.childpointer[r + 1];
                    xx.childpointer[0] = z;
                    xx.childpointer[1] = x;
                    z.parentpointer[0] = xx;
                    x.parentpointer[0] = xx;
                    System.out.println("workinf completed");

                    return;
                } else {
                    int e = (k + 1) / 2;
                    xx.data[0] = z.data[e - 1];
                    for (int i = 0; i < e - 1; i++) {
                        x.data[i] = z.data[(i + e)];
                        x.i++;
                        z.i--;
                        x.childpointer[i + 1] = z.childpointer[1 + (i + e)];
                    }
                    x.childpointer[0] = z.childpointer[e];
                    xx.childpointer[0] = z;
                    xx.childpointer[1] = x;
                    z.parentpointer[0] = xx;
                    x.parentpointer[0] = xx;
                    System.out.println("workinf completed");
                    return;

                }

            }

            else if (z.parentpointer[0] != null) {
                System.out.println("weenfnenefwhyfihyefbybfbifbibfiwbfwiffwbnf");
                bpnode x = new bpnode(order);
                z.data[order - 1] = key;
                z.childpointer[order] = x;
                sort(z, order);
                z.i++;
                bpnode xx = new bpnode(order);
                xx = z.parentpointer[0];
                int k = order;
                System.out.println("pasrenbdhbhdbvbhksdhbfhkbdkhbkd");

                if (k % 2 == 0) {
                    int r = k / 2;
                    if (xx.i == order - 1) {
                        for (int i = 0; i < r - 1; i++) {
                            x.data[i] = z.data[1 + (i + (order / 2))];
                            z.i--;
                            x.i++;
                            x.childpointer[i + 1] = z.childpointer[2 + (i + (order / 2))];
                        }
                        x.childpointer[0] = z.childpointer[r + 1];
                        x.parentpointer[0] = xx;

                        insertdatainaninternalnode(xx, x, order, z.data[(order) / 2]);

                    } else {
                        xx.data[xx.i] = z.data[((order) / 2)];
                        xx.childpointer[xx.i + 1] = x;
                        xx.i++;
                        sort(xx, order);
                        for (int i = 0; i < r - 1; i++) {
                            x.data[i] = z.data[1 + (i + (order / 2))];
                            z.i--;
                            x.i++;
                            x.childpointer[i + 1] = z.childpointer[2 + (i + (order / 2))];
                        }
                        x.childpointer[0] = z.childpointer[r + 1];
                        x.parentpointer[0] = xx;
                    }
                }

                else {
                    int e = (k + 1) / 2;
                    if (xx.i == order - 1) {

                        for (int i = 0; i < e - 1; i++) {
                            x.data[i] = z.data[(i + e)];
                            x.i++;
                            z.i--;
                            x.childpointer[i + 1] = z.childpointer[i + 1 + e];
                        }
                        x.childpointer[0] = z.childpointer[e];
                        x.parentpointer[0] = xx;
                        insertdatainaninternalnode(xx, x, order, z.data[e - 1]);

                    } else {
                        xx.data[xx.i] = z.data[e - 1];
                        xx.childpointer[xx.i + 1] = x;
                        sort(xx, order);
                        xx.i++;
                        for (int i = 0; i < e - 1; i++) {
                            x.data[i] = z.data[(i + e)];
                            x.i++;
                            z.i--;
                            x.childpointer[i + 1] = z.childpointer[i + 1 + e];
                        }
                        x.childpointer[0] = z.childpointer[e];
                        x.parentpointer[0] = xx;
                        return;
                    }
                }
                return;
            }
        } else {
            z.childpointer[z.i + 1] = y;
            z.data[z.i] = y.data[0];
            sort(z, order);
            z.i++;
            return;
        }
    }

    public void splitleafnodeandinsert(bpnode node, int order, int key) {
        System.out.println("split happened");

        if (node.parentpointer[0] == null) {
            bpnode y = new bpnode(order);
            y.next[0] = node.next[0];
            System.out.println("no parent works fine");
            bpnode z = new bpnode(order);
            int k = order;
            root.next[0] = z;
            if (k % 2 == 0) {
                int r = k / 2;
                System.out.println("no parent condition 1");
                for (int j = 0; j < r; j++) {
                    y.data[j] = node.data[j + ((order / 2))];
                    node.i = node.i - 1;
                    y.i++;
                    y.childpointer[j + 1] = node.childpointer[j + (2 + (order / 2))];
                }
            } else {
                System.out.println("no parnet condition 2");
                int e = (k + 1) / 2;
                for (int j = 0; j < e; j++) {
                    y.data[j] = node.data[j + ((1 + order) / 2) - 1];
                    node.i--;
                    y.i++;
                    y.childpointer[j + 1] = node.childpointer[j + 1 + ((1 + order) / 2)];
                }
            }
            node.next[0] = y;
            z.data[0] = y.data[0];
            z.i++;
            node.parentpointer[0] = z;
            y.parentpointer[0] = z;
            z.childpointer[0] = node;
            z.childpointer[1] = y;
            return;
        } else {
            bpnode a = new bpnode(order);
            a.next[0] = node.next[0];
            System.out.println("parent split");

            bpnode p = new bpnode(order);
            p = node.parentpointer[0];
            int k = order;

            if (k % 2 == 0) {
                for (int j = 0; j < order - 2; j++) {
                    a.data[j] = node.data[j + ((order / 2))];
                    node.i = node.i - 1;
                    a.i++;
                    a.childpointer[j + 1] = node.childpointer[j + (2 + (order / 2))];
                }
                System.out.println("splitworks");

                insertdatainaninternalnode(p, a, order, a.data[0]);
                node.next[0] = a;
                a.parentpointer[0] = p;
                return;
            } else {
                for (int j = 0; j <= order - 2; j++) {
                    a.data[j] = node.data[j + ((1 + order) / 2) - 1];
                    node.i--;
                    a.i++;
                    a.childpointer[j + 1] = node.childpointer[j + 1 + ((1 + order) / 2)];
                }
                System.out.println("splitworkd11");
                insertdatainaninternalnode(p, a, order, a.data[0]);
                node.next[0] = a;
                a.parentpointer[0] = p;
                return;

            }

        }

    }

    public void sort(bpnode node, int order) {
        int temp;
        for (int t = 0; t < node.i + 1; t++) {
            for (int j = 0; j < node.i - t; j++) {
                if (node.data[j] > node.data[j + 1]) {
                    temp = node.data[j];
                    node.data[j] = node.data[j + 1];
                    node.data[j + 1] = temp;

                    node.childpointer[order + 1] = node.childpointer[j + 1];
                    node.childpointer[j + 1] = node.childpointer[j + 2];
                    node.childpointer[j + 2] = node.childpointer[order + 1];
                }
            }
        }
        return;
    }

    public void findandinsert(bpnode node, int order, int key) {
        node.data[node.i] = key;
        sort(node, order);
        node.i = node.i + 1;
        return;

    }

    public void insertatleaf(int order, boolean isnonode, int key) {
        bpnode cuurentnode = new bpnode(order);
        bpnode temp = new bpnode(order);
        if (isnonode == true) {
            countnode++;
            bpnode node = new bpnode(order);
            node.data[0] = key;
            head.next[0] = node;
            node.i = node.i + 1;
            root.next[0] = node;
            return;
        }

        else if (isnonode == false) {
            cuurentnode = head.next[0];
            temp = cuurentnode.next[0];
            while (cuurentnode != null) {
                if ((cuurentnode.data[0] <= key) && (temp != null) && (temp.data[0] > key)) {
                    if (cuurentnode.i == order - 1) {
                        cuurentnode.data[cuurentnode.i] = key;
                        sort(cuurentnode, order);
                        cuurentnode.i++;
                        splitleafnodeandinsert(cuurentnode, order, key);
                        return;
                    } else {
                        findandinsert(cuurentnode, order, key);
                        return;
                    }
                } else if (temp == null) {
                    if (cuurentnode.i == (order - 1)) {
                        cuurentnode.data[order - 1] = key;
                        sort(cuurentnode, order);
                        cuurentnode.i++;
                        splitleafnodeandinsert(cuurentnode, order, key);
                        return;
                    } else {
                        findandinsert(cuurentnode, order, key);

                    }
                    return;

                } else if ((cuurentnode.data[0] < key) && (temp.data[0] > key) && (temp != null)) {
                    if (cuurentnode.i == (order - 1)) {
                        cuurentnode.data[order - 1] = key;
                        sort(cuurentnode, order);
                        cuurentnode.i++;
                        splitleafnodeandinsert(cuurentnode, order, key);
                        return;
                    } else {
                        findandinsert(cuurentnode, order, key);

                    }
                    return;
                }

                else {
                    temp = temp.next[0];
                    cuurentnode = cuurentnode.next[0];

                }

            }
            return;
        }
    }

    public int countlevel(int order) {
        int count = 0;
        bpnode cnode = new bpnode(order);
        cnode = head.next[0];
        while (cnode.parentpointer[0] != null) {
            count++;
            cnode = cnode.parentpointer[0];
        }
        return count;
    }

    public int display(int order) {
        bpnode currnode = new bpnode(order);
        currnode = head.next[0];
        while (currnode != null) {
            for (int j = 0; j < currnode.i; j++) {
                //System.out.print(currnode.data[j] + ", ");
                return currnode.data[j];
            }
            System.out.print("  =>");

            currnode = currnode.next[0];
        }
        //return ;
        return order;
    }

    public void search(int order) {
        System.out.println("Enter an element to be searched: ");
        int key = input.nextInt();
        bpnode currnode = new bpnode(order);
        currnode = head.next[0];
        while (currnode != null) {
            for (int j = 0; j < currnode.i; j++) {
                if (currnode.data[j] == key) {
                    System.out.println("Element found");
                    return;
                }

            }

            currnode = currnode.next[0];
        }
        System.out.println("Element not found\n");
        return;

    }

  
}
class Frame1
{
Frame1()
{
    Frame f = new Frame();
        f.setSize(400,400); 
        Label l1 = new Label("Insertion");
        l1.setBounds(40,40, 100, 20);
        Label l2 = new Label("Array Size");
        l2.setBounds(40,70, 70, 20);    
        Label l3 = new Label("Inputs");
        l3.setBounds(40,100, 50, 20);
        Label lf = new Label("");
        lf.setBounds(40,130, 50, 20);
        
        TextField t1 = new TextField(""); 
        t1.setBounds(130, 70, 100, 20);
        TextField t2 = new TextField(""); 
        t2.setBounds(120, 100, 100, 20);
        TextField t3 = new TextField(""); 
        t3.setBounds(110, 130, 60, 20);
        
        Button b = new Button("Display "); 
        b.setBounds(40,210,100,30);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                bptreeone p = new bptreeone();
                String i = t1.getText(); 
                String j = t2.getText(); 
                Button m = (Button)e.getSource();
                Integer n1 = Integer.parseInt(i);
                int a = 0;
                String answer = " " ;
                MaxHeap maxHeap = new MaxHeap(100);
                boolean isnonode;
                        for (int acb = 0; acb < n1; acb++) {
                            //System.out.println("Enter the data:");
                            //n2 = i.nextInt();
                            Integer n2 = Integer.parseInt(j);
                            if (a >= 1) {
                                isnonode = false;
                            } else {
                                isnonode = true;
                                a++;
                            }
                            maxHeap.insert(n1);
                            p.insertatleaf(n1, isnonode, n2);
                        } 
                if(m==b)
                {
                    // yaar yeh kya proble hai int and string ka meko nahi samajh raha.
                    //AWT mai Loop nahi lag raha Jo main code main hai.
                //  answer = p.display(n1);
                
                  t3.setText(  (char) p.display(n1));
                }
            }
        } );
        Button b1 = new Button("Display Heap"); 
        b1.setBounds(150,210,100,30);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                MaxHeap maxHeap = new MaxHeap(100);
                maxHeap.print();
                System.out.println("The max is " + maxHeap.extractMax());
            }
        });
        Button b2 = new Button("Exit"); 
        b2.setBounds(260,210,60,30);
        b2.addActionListener(e->f.dispose());
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        /*f.add(l4);
        f.add(l5);
        f.add(l6);
        
        f.add(c);
        f.add(c1);
        f.add(c2);*/
        f.add(b1);
        f.add(b2);
        f.add(b);
        f.setSize(400,400); 
        f.setLayout(null); 
        f.setVisible(true);
}
}
public class guibptree extends Frame {
    TextField tf1, tf2, tf3, tf4;
    Label lf, l1, l2, l3, l4;
    Button b1, b2, b3, b4;

    guibptree() {
        Frame f = new Frame();
        f.setTitle("B+ Tree");
        f.setSize(400, 400);
       // f.setLayout(new GridLayout(3, 1));
        f.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
        tf1 = new TextField();
       // tf2 = new TextField();
      // tf3 = new TextField();
       // tf4 = new TextField();

        b1 = new Button("Submit1");
        b2 = new Button("Insert");
        b3 = new Button("Delete");
        b4 = new Button("Search");

        l1 = new Label("Enter the Order");
        //l2 = new Label("Insertion");
        //l3 = new Label("Search");
        //l4 = new Label("Deletion");
        lf = new Label("",Label.CENTER);

        tf1.setBounds(160, 50, 150, 30);
       // tf2.setBounds(160, 85, 150, 30);
       // tf3.setBounds(160, 120, 150, 30);
       // tf4.setBounds(160, 155, 150, 30);

        b1.setBounds(320, 50, 100, 30);
        b2.setBounds(200, 85, 100, 30);
        b3.setBounds(200, 120, 100, 30);
        b4.setBounds(200, 155, 100, 30);

        l1.setBounds(15, 50, 150, 30);
       // l2.setBounds(15, 85, 150, 30);
       // l3.setBounds(15, 120, 150, 30);
      //  l4.setBounds(15, 155, 150, 30);
        lf.setBounds(100, 300, 200, 30);

        f.add(l1);
      //  f.add(l2);
        //f.add(l3);
        //f.add(l4);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(tf1);
       // f.add(tf2);
       // f.add(tf3);
       // f.add(tf4);
        f.add(lf);
        f.setSize(500, 400);
        f.setVisible(true);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(tf1.getText());
                lf.setText("Order is = " + String.valueOf(a));
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Frame1();
                lf.setText("Insetion is done!!");
            }
        }); 
        
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                lf.setText("Element Deleted " );
            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                lf.setText("Search Done" );
            }
        });
    }


    public static void main(String[] args) {
        new guibptree();
    }
}