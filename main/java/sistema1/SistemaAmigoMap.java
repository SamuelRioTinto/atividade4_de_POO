package sistema1;

import java.util.*;
public class SistemaAmigoMap {
    private Map<String, Amigo> Amigos;
    private Map<String, Mensagem> Mensagems;

    public SistemaAmigoMap() {
        this.Amigos = new HashMap<>();
        this.Mensagems = new HashMap<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
        this.Amigos.put(amigo.getEmail(), amigo);
    }

    public List<Mensagem> pesquisarMensagensAnonimas() {
        List<Mensagem> mensagensAnonimais = new ArrayList<>();
        for (Mensagem mensagenAnonima : this.Mensagems.values()) {
            if (mensagenAnonima.ehAnonima()) {
                mensagensAnonimais.add(mensagenAnonima);
            }
        }
        return mensagensAnonimais;

    }

    public Amigo pesquisaAmigo(String emailAmigo) {
        Amigo amigo = this.Amigos.get(emailAmigo);
        return amigo;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo amigoEscolido = this.Amigos.get(emailDaPessoa);
        if (amigoEscolido!=null) {
            amigoEscolido.setEmailAmigoSorteado(emailAmigoSorteado);
        } else {
            throw new AmigoInexistenteException("a pessoa de email "+emailDaPessoa+" não existe no sistema ");
        }
    }

    public List<Mensagem> pesquisarTodasAsMensagens() {
        List<Mensagem> exibir = new ArrayList<>();
        exibir.addAll(Mensagems.values());
        return exibir;
    }

    public String pesquisarAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigoSecreto=this.Amigos.get(emailDaPessoa);
        if(amigoSecreto !=null && amigoSecreto.getEmailAmigoSorteado()==null){
            throw new AmigoNaoSorteadoException("o email do amigo sorteado ainda não foi cadastrado");
        }else if(amigoSecreto!=null){
            return amigoSecreto.getEmailAmigoSorteado();
        }else{
            throw new AmigoInexistenteException("a pessoa de email " + emailDaPessoa + " não esta cadastrada");
        }
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonimo) {
        Mensagem mensagemParaTodos = new MensagemParaTodos(texto, emailRemetente, ehAnonimo);
        Mensagems.put(mensagemParaTodos.getEmailRemetente(),mensagemParaTodos);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ahAnonimo) {
        Mensagem mensagemParaAlquem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ahAnonimo);
        Mensagems.put(mensagemParaAlquem.getEmailRemetente(),mensagemParaAlquem);
    }
}







