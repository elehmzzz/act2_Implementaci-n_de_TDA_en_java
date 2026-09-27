package com.mycompany.actividad2_parcial1_implementacion_tda;
/*
autor: Eleuterio Hernandez Martin
Grupo: B
Grado: 4 cuatrimestre
Materia: Estructura de Datos
*/
public class Potencia {
    private float base;
    private float exponente;
    
    //getters
    public float getBase(){
        return base;
    }
    public float getExponente(){
        return exponente;
    }
    //setters
    public void setBase(float b){
        base = b;
    }
    public void setExponente(float expo){
        exponente = expo;
    }
    //constructor vacio
    public Potencia(){
        base = 0;
        exponente = 0;
    }
    //constructor parametrizado
    public Potencia(float base, float exponente){
        this.base = base;
        this.exponente = exponente;
    }
    
    //4 metodos del TDA
    public float calcularPotencia(){
        if(base>0 && exponente>0){  //ejemplo: 3^3
            return calPotenciaPositivo(base, exponente);
        }
        else if(base>0 && exponente==0){//ejemplo: 4^0
            return 1;
        }
        else if(base ==0 && exponente>0){ //ejemplo: 0^2
            return 0;
        }
        else if(base >0 && exponente<0){ //ejemplo: 3^-2
            return calPotenciaConExponenteNegativo(base,exponente);
        }
        else if(base<0 && exponente>0){ //ejemplo: -3^2
            return calPotenciaPositivo(base, exponente);
        }
        return 0;
    }
    //metodo clacula potencia cuando el exponenten es negativo
    public float calPotenciaConExponenteNegativo(float b, float expo){
        float nuevoExponente = -1 * expo;
        return 1/(calPotenciaPositivo(b,nuevoExponente));
    }
    //metodo recursivo
    public float calPotenciaPositivo(float b, float expo){
        if(expo==0)
            return 1;
        return b * calPotenciaPositivo(b, expo -1);
    }
    //metodo para mostrar el resultado
    public String mostrarResultado(){
        float resultado = calcularPotencia();
        return String.valueOf(resultado);
    }
    //metodo para mostrar el resultado en una lista de resultados
    public String mostrarHistorial(){
        return String.format("Base: %.3f Exponente: %.3f Resultado: %.3f",base,exponente,calcularPotencia());
    }
     
}
