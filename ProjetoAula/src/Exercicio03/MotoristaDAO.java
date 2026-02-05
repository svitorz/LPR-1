/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio03;

/**
 *
 * @author svitorz
 */
public class MotoristaDAO {
    private boolean podeTerCnh(int idade){
        return idade >= 18;
    }
    
    public String motoristaPodeTerCnh(MotoristaDTO dto){
        return podeTerCnh(dto.getIdade()) ? "Pode ter CNH!" : "Não pode ter CNH.";
    }
}
