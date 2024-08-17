package sistema1;

public class MensagemParaTodos extends Mensagem{
    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima){
        super(texto,emailRemetente,anonima);
    }

    public String getTextoCompletoAExibir(){
        if(ehAnonima()){
            return "mensagen para todos. texto: "+super.getTexto();
        }else{
            return "mensagem de "+getEmailRemetente()+" para todos texto: "+super.getTexto();
        }
    }
}
