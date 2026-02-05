package Exercicio01;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author svitorz
 */
public class ClienteDAO {

    public String mostrarNomeRg(ClienteDTO cli) {
        return "O nome informado foi: " + cli.getName()
                + "\nO rg informado foi:" + cli.getRg();
    }

    public String mostrarNomeIdade(ClienteDTO cli) {
        return "O nome informado foi: " + cli.getName()
                + "\nA idade informada foi:" + cli.getIdade();
    }
}
