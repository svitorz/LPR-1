/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio02;

/**
 *
 * @author svitorz
 */
public class ClienteCTR {

    ClienteDAO dao = new ClienteDAO();

    public String mostrarNomeRg(ClienteDTO dto) {
        return dao.mostrarNomeRg(dto);
    }

    public String mostrarNomeIdade(ClienteDTO dto) {
        return dao.mostrarNomeIdade(dto);
    }
}
