import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingGUI {
    private ShoppingCart shoppingCart;

    public ShoppingGUI() {
        shoppingCart = new ShoppingCart();

        // Create the frame
        JFrame frame = new JFrame("Shopping Cart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Panel for item selection
        JPanel selectionPanel = new JPanel();
        JComboBox<Item> itemComboBox = new JComboBox<>();
        itemComboBox.addItem(new Item("Tissues", 3.00));
        itemComboBox.addItem(new Item("Soap", 1.50));
        JTextField quantityField = new JTextField(5);
        JButton addButton = new JButton("Add to Cart");

        selectionPanel.add(new JLabel("Item:"));
        selectionPanel.add(itemComboBox);
        selectionPanel.add(new JLabel("Quantity:"));
        selectionPanel.add(quantityField);
        selectionPanel.add(addButton);

        // Panel for the shopping cart display
        JTextArea cartArea = new JTextArea(10, 30);
        cartArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(cartArea);
        JButton calculateButton = new JButton("Calculate Total");

        // Add components to the frame
        frame.getContentPane().add(selectionPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(calculateButton, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item selectedItem = (Item) itemComboBox.getSelectedItem();
                int quantity;
                try {
                    quantity = Integer.parseInt(quantityField.getText());
                    if (quantity < 1) throw new NumberFormatException();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid quantity.", "Invalid Quantity", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                shoppingCart.addOrder(new ItemOrder(selectedItem, quantity));
                cartArea.append(quantity + " x " + selectedItem.getName() + "\n");
                quantityField.setText("");
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalCost = shoppingCart.getTotalCost();
                cartArea.append("Total Cost: $" + String.format("%.2f", totalCost) + "\n");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShoppingGUI();
            }
        });
    }
}
