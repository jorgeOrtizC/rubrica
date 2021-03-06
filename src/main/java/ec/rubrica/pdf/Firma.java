/*
 * Copyright (c) 2009-2013 Rubrica.ec
 * 
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 */

package ec.rubrica.pdf;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Calendar;

/**
 * Representa una firma digital sobre un documento PDF.
 * 
 * @author Ricardo Arguello <ricardo@rubrica.ec>
 */
public class Firma {

	private String nombre;
	private boolean firmaCubreTodoDocumento;
	private int revision;

	private X509Certificate certificadoFirmante;
	private Calendar fechaFirma;
	private Certificate[] certificados;
	private boolean selladoTiempoCorrecto;
	private boolean documentoModificado;

	private Falla falla = null;
	private boolean isOscpSignatureValid = false;
	private boolean isOscpRevocationValid = false;

	public Firma(String nombre, boolean firmaCubreTodoDocumento, int revision,
			X509Certificate certificadoFirmante, Calendar fechaFirma,
			boolean selladoTiempoCorrecto, Certificate[] certificados,
			boolean documentoModificado) {
		this.nombre = nombre;
		this.certificadoFirmante = certificadoFirmante;
		this.firmaCubreTodoDocumento = firmaCubreTodoDocumento;
		this.revision = revision;
		this.fechaFirma = fechaFirma;
		this.selladoTiempoCorrecto = selladoTiempoCorrecto;
		this.certificados = certificados;
		this.documentoModificado = documentoModificado;
	}

	public String getNombre() {
		return nombre;
	}

	public X509Certificate getCertificadoFirmante() {
		return certificadoFirmante;
	}

	/**
	 * Esta firma cubre todo el documento PDF?
	 */
	public boolean firmaCubreTodoDocumento() {
		return firmaCubreTodoDocumento;
	}

	/**
	 * Esta firma es la revision numero?
	 * 
	 * @return
	 */
	public int getRevision() {
		return this.revision;
	}

	/**
	 * En que fecha fue firmado el documento?
	 * 
	 * @return
	 */
	public Calendar getFechaFirma() {
		return fechaFirma;
	}

	/**
	 * Este documento verifica correctamente su sellado de tiempo, si es que lo
	 * tiene.
	 * 
	 * @return
	 */
	public boolean selladoTiempo() {
		return selladoTiempoCorrecto;
	}

	public Certificate[] getCertificados() {
		return certificados;
	}

	public boolean isDocumentoModificado() {
		return documentoModificado;
	}

	public Falla getFalla() {
		return falla;
	}

	public void setFalla(Falla falla) {
		this.falla = falla;
	}

	public boolean tieneFalla() {
		return (falla != null);
	}

	/**
	 * @return the isOscpSignatureValid
	 */
	public boolean isOscpSignatureValid() {
		return isOscpSignatureValid;
	}

	/**
	 * @param isOscpSignatureValid
	 *            the isOscpSignatureValid to set
	 */
	public void setOscpSignatureValid(boolean isOscpSignatureValid) {
		this.isOscpSignatureValid = isOscpSignatureValid;
	}

	/**
	 * @return the isOscpRevocationValid
	 */
	public boolean isOscpRevocationValid() {
		return isOscpRevocationValid;
	}

	/**
	 * @param isOscpRevocationValid
	 *            the isOscpRevocationValid to set
	 */
	public void setOscpRevocationValid(boolean isOscpRevocationValid) {
		this.isOscpRevocationValid = isOscpRevocationValid;
	}
}