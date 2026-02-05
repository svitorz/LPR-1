/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio03;

/**
 *
 * @author svitorz
 */
public class MotoristaCTR {
    MotoristaDAO dao = new MotoristaDAO();
    public String motoristaPodeTerCnh(MotoristaDTO dto){
        return dao.motoristaPodeTerCnh(dto);
    }
}
