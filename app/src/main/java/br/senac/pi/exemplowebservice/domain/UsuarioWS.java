package br.senac.pi.exemplowebservice.domain;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by Aluno on 14/12/2015.
 */
public class UsuarioWS {
    private static final String NAMESPACE = "http://exemplows.pi.senac.br";
    private static final String URL = "http://10.19.14.15:8080/ExemploWS/services/UsuarioDAO?wsdl";

    private static final String INSERIR = "insertUsuario";
    private static final String ATUALIZAR = "atualizarUsuario";
    private static final String EXCLUIR = "excluirUsuario";
    private static final String BUSCAR_POR_ID = "buscarUsuarioPorID";
    private static final String BUSCAR_TODOS = "listarTodosUsuarios";

public boolean insertUsuario(Usuario usuario){
    try{
        SoapObject soapObject = new SoapObject(NAMESPACE, INSERIR);
        SoapObject user = new SoapObject(NAMESPACE,"usuario");
        user.addProperty("id", usuario.getId());
        user.addProperty("nome", usuario.getNome());
        user.addProperty("idade", usuario.getIdade());
        soapObject.addSoapObject(user);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.implicitTypes = true;
        envelope.setOutputSoapObject(soapObject);
        HttpTransportSE transportSE = new HttpTransportSE(URL);
        transportSE.call("urn:" + INSERIR, envelope);
        Object resposta = envelope.getResponse();
        return Boolean.parseBoolean(resposta.toString());

    }catch (Exception e){
        e.printStackTrace();
        return false;
    }
}
}
