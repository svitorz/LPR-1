/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio01;

import javax.swing.JOptionPane;

/**
 *
 * @author svitorz
 */
public class ClienteVIEW {

    public static void main(String[] args) {
        try {
            ClienteCTR ctr = new ClienteCTR();
            ClienteDTO dto = new ClienteDTO();

            dto.setName(JOptionPane.showInputDialog("Informe seu nome:"));
            dto.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe sua idade:")));
            dto.setRg(JOptionPane.showInputDialog("Informe seu rg:"));

            JOptionPane.showMessageDialog(null, ctr.mostrarNomeIdade(dto));
            JOptionPane.showMessageDialog(null, ctr.mostrarNomeRg(dto));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
