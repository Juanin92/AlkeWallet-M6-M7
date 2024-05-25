$(document).ready(function() {

    // para cambiar en pantalla de iniciar sesion a crear cuenta en el mismo contendor(Pc)
    $('#registerButtonToggle').click(function() {
        $('#container').addClass('active');
    });
    $('#loginButtonToggle').click(function() {
        $('#container').removeClass('active');
    });

    // para cambiar en pantalla de iniciar sesion a crear cuenta en el mismo contendor(Telefono)
    $('#buttonRegister').click(function() {
        $('.sign-in').css({
          opacity: 0,
          zIndex: 0,
        },600);
        $('.sign-up').css({
          opacity: 1,
          zIndex: 1,
        },600);
    });

    $('#buttonCreate').click(function() {
        $('.sign-up').css({
          opacity: 0,
          zIndex: 0,
        },600);
        $('.sign-in').css({
          opacity: 1,
          zIndex: 1,
        },600);
    });
});