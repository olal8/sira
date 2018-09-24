package mx.com.sira.front.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;

public class MsgBeanUtil {
	private static final String DLG_BASICO = "wIdAlertas";
	private static final String WARNIG_MSG = "Warning! ";
	private static final String ERROR_MSG = "Error! ";
	private static final String FATAL_MSG = "Fatal! ";
	private static final String INFO_MSG = "Info! ";

	private MsgBeanUtil() {
	}
	
public static void mensajes() {
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity."); 
    PrimeFaces.current().dialog().showMessageDynamic(message);
}

	private static void enviaMensaje(Severity severity, String mensaje, String error, String... dialog) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, error, mensaje));
		RequestContext rc = RequestContext.getCurrentInstance();
		rc.execute(((dialog == null || dialog.length == 0) ? DLG_BASICO : dialog[0]) + ".show()");
	}

	private static void enviaMensajeRedirecciona(Severity severity, String mensaje, String error) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, error, mensaje));
		RequestContext rc = RequestContext.getCurrentInstance();
		rc.execute("alertaRedirecciona.show()");
	}

	public static void infoRedirecciona(String mensaje) {
		enviaMensajeRedirecciona(FacesMessage.SEVERITY_INFO, mensaje, INFO_MSG);
	}

	public static void warn(String mensaje, String... dialog) {
		enviaMensaje(FacesMessage.SEVERITY_WARN, mensaje, WARNIG_MSG, dialog);
	}

	public static void error(String mensaje, String... dialog) {
		enviaMensaje(FacesMessage.SEVERITY_ERROR, mensaje, ERROR_MSG, dialog);
	}

	public static void fatal(String mensaje, String... dialog) {
		enviaMensaje(FacesMessage.SEVERITY_FATAL, mensaje, FATAL_MSG, dialog);
	}

	public static void info(String mensaje, String... dialog) {
		enviaMensaje(FacesMessage.SEVERITY_INFO, mensaje, INFO_MSG, dialog);
	}

	public static void ejecutaAccion(String accion) {
		RequestContext rc = RequestContext.getCurrentInstance();
		rc.execute(accion);
	}
}
