import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
// import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Main {
    static int sortOption = 1;           //Set default sorring algorithm to Insertion Sort
    static int numberOfElements = 25000;   //Set default number of element to 100
    static int orderOption = 1;          //Set default array ordering to in-order
    static Integer[] intArray = null;
    static boolean createNewArray = true;
    static int totalSortTime = 0;
    static String[] sortAlgorithmName = {"Insertion sort", "Selection sort", "Quick sort", "Merge sort", "Heap sort", "Radix sort"};
    static String[] dataOrder = {"In-Order", "Reverse-Order", "Almost Ordered", "Random"};
    static int numberMovements = 0;
    static int numberComparisions = 0;
    public static void main(String[] args){

        //Make GUI outer frame
        JFrame frame = new JFrame("Sorting Algorithm Analysis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(540,400);
        // frame.setMinimumSize(new Dimension(620,400));
        // frame.setMaximumSize(new Dimension(620,400));
        frame.setLayout(new BorderLayout());

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////

        //Making Selected algorithm
        JPanel winningPanel = new JPanel();
        winningPanel.setBorder(BorderFactory.createTitledBorder("Selected Algorithm"));
        winningPanel.setPreferredSize(new Dimension(350, 60));
        JLabel winningAlg = new JLabel("Insertion Sort");
        winningAlg.setFont(new Font("Arial", Font.BOLD, 20));
        winningAlg.setAlignmentX(SwingConstants.CENTER);
        winningPanel.add(winningAlg);
        winningPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        winningPanel.setPreferredSize(new Dimension(400,60));

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////

        //Making algorithm chooser
        JButton insertSort = new JButton("Insertion Sort");
        JButton selectionSort = new JButton("Selection Sort");
        JButton quickSort = new JButton("Quick Sort");
        JButton mergeSort = new JButton("Merge Sort");
        JButton heapSort = new JButton("Heap Sort");
        JButton radixSort = new JButton("Radix Sort");

        insertSort.setPreferredSize(new Dimension(120,200));
        selectionSort.setPreferredSize(new Dimension(120,200));
        quickSort.setPreferredSize(new Dimension(120,200));
        mergeSort.setPreferredSize(new Dimension(120,200));
        heapSort.setPreferredSize(new Dimension(120,200));
        radixSort.setPreferredSize(new Dimension(120,200));

        insertSort.setFocusPainted(false);
        selectionSort.setFocusPainted(false);
        quickSort.setFocusPainted(false);
        mergeSort.setFocusPainted(false);
        heapSort.setFocusPainted(false);
        radixSort.setFocusPainted(false);

        //Button event listener

        insertSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortOption = 1;
                winningAlg.setText(insertSort.getText());
            }
        });
        selectionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortOption = 2;
                winningAlg.setText(selectionSort.getText());
            }
        });
        quickSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortOption = 3;
                winningAlg.setText(quickSort.getText());
            }
        });
        mergeSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortOption = 4;
                winningAlg.setText(mergeSort.getText());
            }
        });
        heapSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortOption = 5;
                winningAlg.setText(heapSort.getText());
            }
        });
        radixSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortOption = 6;
                winningAlg.setText(radixSort.getText());
            }
        });

        JPanel buttons = new JPanel(new GridLayout(0, 1, 10, 0));
        buttons.setBorder(BorderFactory.createTitledBorder("Sorting Algorithms"));
        buttons.add(insertSort);
        buttons.add(selectionSort);
        buttons.add(quickSort);
        buttons.add(mergeSort);
        buttons.add(heapSort);
        buttons.add(radixSort);

        JPanel left = new JPanel(new BorderLayout());
        left.add(buttons, BorderLayout.LINE_START);
        frame.add(left, BorderLayout.LINE_START);

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////

        //List properties
        JPanel listProps = new JPanel();
        listProps.setBorder(BorderFactory.createTitledBorder("List Properties"));
        listProps.setPreferredSize(new Dimension(400, 130));
        //List order
        JRadioButton m1, m2, m3, m4;
        ButtonGroup orderSelect = new ButtonGroup();
        m1 = new JRadioButton("In-Order");
        m2 = new JRadioButton("Reverse-Order");
        m3 = new JRadioButton("Almost Ordered");
        m4 = new JRadioButton("Random");
        orderSelect.add(m1);
        orderSelect.add(m2);
        orderSelect.add(m3);
        orderSelect.add(m4);
        listProps.add(m1);
        listProps.add(m2);
        listProps.add(m3);
        listProps.add(m4);
        m1.setSelected(true);
        //Order Selector event listener
        m1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                int state = event.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    if(orderOption != 1){
                        orderOption = 1;
                        createNewArray = true;
                    }
                    // System.out.println(orderOption);
                }
            }
        });
        m2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                int state = event.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    if(orderOption != 2){
                        orderOption = 2;
                        createNewArray = true;
                    }
                    // System.out.println(orderOption);
                }
            }
        });
        m3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                int state = event.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    if(orderOption != 3){
                        orderOption = 3;
                        createNewArray = true;
                    }
                    // System.out.println(orderOption);
                }
            }
        });
        m4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                int state = event.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    if(orderOption != 4){
                        orderOption = 4;
                        createNewArray = true;
                    }
                    // System.out.println(orderOption);
                }
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////

        //List number of element slider
        //Number of element manual keyboard input
        JSlider listElements = new JSlider(0,50000);
        JTextField listElementNumber = new JTextField();
        listElementNumber.setPreferredSize(new Dimension(100,25));
        listElementNumber.setText("25000");
        listElements.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent ce) {
                listElementNumber.setText(String.format("%d", listElements.getValue()));
                numberOfElements = listElements.getValue();
                createNewArray = true;
            }
        });

        JLabel createListStatus = new JLabel("No List Created");
        listElementNumber.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(listElementNumber.getText());
                if(n < 0)
                    n = 0;
                listElements.setValue(n);
                numberOfElements = n;
                intArray = null;
                intArray = arrayGenerate(numberOfElements, orderOption);
                createNewArray = false;
                createListStatus.setText(String.valueOf(numberOfElements) + " elements created");
                // System.out.println(listElements.getValue());
                // System.out.println(orderOption);
            }
        });
        listElementNumber.addFocusListener(new FocusListener(){
            @Override
            public void focusLost(FocusEvent e) {
                int n = Integer.parseInt(listElementNumber.getText());
                if(n < 0)
                    n = 0;
                listElements.setValue(n);
                numberOfElements = n;
                createNewArray = true;
                // System.out.println(listElements.getValue());
            }

            @Override
            public void focusGained(FocusEvent e) {
            }
        });
        listProps.add(listElements);
        listProps.add(listElementNumber);
        JButton createListButton = new JButton("Create List");

        //Used later in result section but needed variable for reference
        //When dealing with event handler
        JLabel numberOfSamples = new JLabel("Total Samples: " + String.valueOf(numberOfElements));
        JLabel dataType = new JLabel("Data Types: In-Order");
        JLabel sortType = new JLabel("Sort Algorithm: Insertion Sort");
        JLabel comparisons = new JLabel("Comparisons: Test not initiated");
        JLabel movement = new JLabel("Movements: Test not initiated");
        JLabel totalTime = new JLabel("Total Time: Test not initiated");


        createListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(createNewArray == true){
                    intArray = null;
                    intArray = arrayGenerate(numberOfElements, orderOption);
                    createNewArray = false;
                }
                createListStatus.setText(String.valueOf(numberOfElements) + " elements created");
            }
        });
        listProps.add(createListButton);
        listProps.add(createListStatus);

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        //Result Panel
        JPanel result = new JPanel();
        result.setBorder(BorderFactory.createTitledBorder("Experimental Results"));
        result.setPreferredSize(new Dimension(400,130));
        JPanel items = new JPanel();
        items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));
        items.setAlignmentX(Component.CENTER_ALIGNMENT);
        items.add(numberOfSamples);
        items.add(dataType);
        items.add(sortType);
        items.add(comparisons);
        items.add(movement);
        items.add(totalTime);
        result.add(items);
        

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////

        //Button to start algorithm analysis
        //Do nothing if array is not created yet
        JButton startAnalysis = new JButton("Start Sorting Algorithm");
        startAnalysis.setPreferredSize(new Dimension(200,25));
        startAnalysis.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(intArray != null){
                    // TODO Auto-generated method stub
                    Integer[] tempArray = new Integer[numberOfElements];
                    System.arraycopy(intArray, 0, tempArray, 0, numberOfElements);
                    long[] info = startSort(tempArray, sortOption);
                    totalSortTime = (int) info[0];

                    numberOfSamples.setText ("Total Samples: " + String.valueOf(numberOfElements));
                    totalTime.setText       ("Total Time: " + String.valueOf(totalSortTime) + " Micro-Seconds");
                    sortType.setText        ("Sort Algorithm: " + sortAlgorithmName[sortOption - 1]);
                    dataType.setText        ("Data Type: " + dataOrder[orderOption - 1]);
                    comparisons.setText     ("Comparisons: " + numberComparisions);
                    movement.setText        ("Movements: " + numberMovements);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No array generated yet!\nPlease click 'Create List' at List Properties");
                }
            }

        });

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        //Adding all items to the right panel and adding right panel to frame
        JPanel right = new JPanel();
        // right.setLayout(new GridLayout(4, 0,0,10));
        right.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        right.add(winningPanel, c);
        c.gridy = 1;
        right.add(listProps, c);
        c.gridy = 2;
        right.add(result, c);
        c.gridy = 3;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.CENTER;
        right.add(startAnalysis,c);

        frame.add(right, BorderLayout.LINE_END);
        frame.setVisible(true);
    }

    //Function used to generate array and its order option
    public static Integer[] arrayGenerate(int size, int order){
        Integer array[] = new Integer[size];
        for(int i = 0; i < size; i++){
            // array[i] = (int) (1999999999*Math.random());
            array[i] = (int) (50000*Math.random());
        }
        //If order != {1,2,3} then leave array at random
    
        //Sorted array
        if(orderOption == 1)
            Arrays.sort(array);
        //Reverse sorted array
        if(orderOption == 2)
            Arrays.sort(array, Collections.reverseOrder());
        //Half sorted array
        if(orderOption == 3)
            // Arrays.sort(array, 0, (int)(size * 0.999));
            Arrays.sort(array, 0, (int)(size * 0.75));
        
        return array;
    }

    //Function to choose which sorting algorithm to use
    //With stop watch, set to micro-seconds
    public static long[] startSort(Integer[] arr, int choice){
        long[] data = {0,0,0};
        int[] t = new int[2];
        long unixTime = System.nanoTime();
        if(choice == 1){
            t = InsertionSort.insertionSort(arr);
        }

        else if(choice == 2){
            t = SelectionSort.selectionSort(arr);
        }

        else if(choice == 3){
            t = QuickSort.quickSort(arr);
        }

        else if(choice == 4){
            t = MergeSort.mergeSort(arr);
            MergeSort.reset();
            
        }

        else if(choice == 5){
            t = HeapSort.heapSort(arr);
            
        }

        else if(choice == 6){
            t = RadixSort.radixsort(arr, arr.length);
        }
        unixTime = System.nanoTime() - unixTime;
        unixTime /= 1000;
        data[0] = unixTime;
        numberComparisions = t[0];
        numberMovements = t[1];
        return data;
    }
}

     // Scanner input = new Scanner(System.in);
        // //Display order option
        // System.out.println("1. InOrder");
        // System.out.println("2. ReverseOrder");
        // System.out.println("3. AlmostOrder");
        // System.out.println("4. Random Order");
        // System.out.print("List Properties, select the data type of list you wish to use: ");
        // int order = input.nextInt();
        // System.out.println();
        
        // //Display input size option
        // System.out.println("1. 5000 ");
        // System.out.println("2. 15000");
        // System.out.println("3. 50000");
        // System.out.print("Input Size, select the size of list: ");
        // int size = input.nextInt();
        // Integer array[] = arrayGenerate(20, order);
        // System.out.println();

        // //Display sorting method option
        // System.out.println("1. Insertion Sort");
        // System.out.println("2. Selection Sort");
        // System.out.println("3. Quick Sort");
        // System.out.println("4. Merge Sort");
        // System.out.println("5. Heap Sort");
        // System.out.println("6. Radix Sort");
        // System.out.print("Sorting Algorithm, select the sorting algorithm: ");
        // int sort = input.nextInt();
        // System.out.println();
        // for(int i : array){
        //     System.out.println(i);
        // }
        // System.out.println();
        // System.out.println("?????????????????????????????????????????");
        // startSort(array, sort);
        // for(int i : array){
        //     System.out.println(i);
        // }