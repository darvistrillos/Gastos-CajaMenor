/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function valida_form_reg(form) {
    if (document.frmgasto.fecha.value == "")
        alert("La fecha no puede estar vacia");
    else {
        if (document.frmgasto.identi.value == "")
            alert("La identificacion no puede estar vacia");
        else {
            if (document.frmgasto.nombre.value == "")
                alert("El nombre no puede estar vacio");
            else {
                if (document.frmgasto.obs.value == "")
                    alert("La observacion no puede estar vacia");
                else {
                    if (document.frmgasto.valor.value == "")
                        alert("El valor no puede estar vacio");
                    else
                        form.submit();
                }

            }
        }
    }
}
