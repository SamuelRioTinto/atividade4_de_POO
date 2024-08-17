package sistema1;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente,String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario=emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoAExibir(){
        if(ehAnonima()){
            return "mensagen para "+emailDestinatario+" texto: "+super.getTexto();
        }else{
            return "mensagem de : "+getEmailRemetente()+" para "+emailDestinatario+" texto: "+super.getTexto();
        }
    }
}
