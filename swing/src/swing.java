import javax.swing.*;
class GuiSwing3 {
    public static void main(String[] args) {
        JFrame marco = new JFrame("Campo, botón y etiqueta");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel etiqueta = new JLabel("No tienen actividad");
        JPanel panel = new JPanel();
        JButton boton = new JButton("Enviar");
        JTextField campotexto = new JTextField(16);
        panel.add(campotexto);
        panel.add(boton);
        panel.add(etiqueta);
        marco.add(panel);
        marco.setSize(300, 300);
        marco.setVisible(true);
    }
}