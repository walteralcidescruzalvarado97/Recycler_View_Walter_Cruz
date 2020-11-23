# Recycler_View_Walter_Cruz
Repositorio para la Tarea de Recycler View de Walter Cruz

Secuencia de la Aplicación =>
    Paso 1 => Se Cargan una Lista de 8 Perros con sus Respectivos Nombres, Imagen de Perfil y la Cantidad de Likes
        
        Paso 1.1 => Si al Perro nunca le han dado Like aparece con 0 Likes y si se le han dado se jalara la Cantidad de    Likes de la Base de Datos.
    
    Paso 2 => Al Darle Like al Perro, pueden succeder 2 Eventos además de poner el Boton de dar Like en disabled para 
              que no se le vuelva a dar Like. 
        
        Evento 1 => Si nunca se le ha dado Like al Perro, significa que no se encuentra dentro de la Base de Datos entonces 
                    se almacenara una Nueva Instancia de la Entidad Perro con su Respectivo Nombre, Imagen y con una Cantidad de Like en 1.

        Evento 2 => Si al Perro ya se le ha dado Like, significa que ya existe una Instancia de ese Perro guardada 
                    en la Base de Datos, entonces no se guardara de nuevo ese Perro dentro de ella, sino que se actualizara la Cantidad de Likes sumandole uno.

    Paso 3 => En la Actividad del Detalle de las Mascotas se mostraran solo los Primeros 5 Perros a los que le han dado like
              Ordenados de mayor a menor por su Cantidad de Likes.

    Paso 4 => Si vuelve a la Actividad Principal podrá dar Likes de Nuevo a los Perros que antes no podía por el Estado
              disabled del Boton de dar Like.
