package sistema1;

import javax.swing.*;
import java.util.List;

public class SistemaAmigoMapTest {

      public static void main (String[] args){

          SistemaAmigoMap sistema=new SistemaAmigoMap();

          sistema.cadastraAmigo("jose","jose.com");
          sistema.cadastraAmigo("maria","maria.com");

          try{
              sistema.configuraAmigoSecretoDe("jose.com","maria.com");
          }catch (AmigoInexistenteException e ){
              JOptionPane.showMessageDialog(null,e.getMessage());
          }

          try{
              sistema.configuraAmigoSecretoDe("maria.com","jose.com");
          }catch (AmigoInexistenteException e ){
              JOptionPane.showMessageDialog(null,e.getMessage());
          }

          try{
              String emailDoAmigosecreto=sistema.pesquisarAmigoSecretoDe("jose.com");
              JOptionPane.showMessageDialog(null,emailDoAmigosecreto);
          }catch (AmigoInexistenteException|AmigoNaoSorteadoException e ){
              JOptionPane.showMessageDialog(null,e.getMessage());
          }

          try{
              String emailDoAmigoSecreto1= sistema.pesquisarAmigoSecretoDe("maria.com");
              JOptionPane.showMessageDialog(null,emailDoAmigoSecreto1);
          }catch (AmigoInexistenteException|AmigoNaoSorteadoException e){
              JOptionPane.showMessageDialog(null,e.getMessage());
          }

          Amigo amigo=sistema.pesquisaAmigo("jose.com");
          JOptionPane.showMessageDialog(null,amigo);
          Amigo amigo1=sistema.pesquisaAmigo("maria.com");
          JOptionPane.showMessageDialog(null,amigo1);

          sistema.enviarMensagemParaTodos("ola como vai","jose.com",true);
          sistema.enviarMensagemParaTodos("voces vam para o cinema sabado","jose.com",false);

          sistema.enviarMensagemParaAlguem("onde voce esta ","jose.com","maria.com",true);
          sistema.enviarMensagemParaAlguem("ok vamos nos encontrar","jose.com","maria.com",false);

          sistema.enviarMensagemParaTodos("vamos","maria.com",true);
          sistema.enviarMensagemParaTodos("reunião ","maria.com",false);

          sistema.enviarMensagemParaAlguem("voce estava doente ","maria.com","jose.com",true);
          sistema.enviarMensagemParaAlguem("qual o clima hoje","maria.com","jose.com",false);

          List<Mensagem> todasAsMensagens=sistema.pesquisarTodasAsMensagens();
          for(Mensagem mensagem:todasAsMensagens){
              JOptionPane.showMessageDialog(null,mensagem.getTextoCompletoAExibir());
          }

          List<Mensagem>mesagensAnonimas=sistema.pesquisarMensagensAnonimas();
          for(Mensagem mensagemAnonima:mesagensAnonimas){
              JOptionPane.showMessageDialog(null,mensagemAnonima.getTextoCompletoAExibir());
          }
      }
}
