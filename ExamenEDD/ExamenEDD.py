duracionViaje = int(input("¿Cuál ha sido la duración de su viaje?, Dato entero: "))

print("Cuál ha sido su modo de viaje\n"
      "Standar - 1\n"
      "Custom - 2\n"
      "X-tra - 3\n")
standar = 0.31
custom = 0.36
xtra = 0.39

opcion = int(input("Elija una opcion: "))

if opcion == 1:
    resul1 = duracionViaje * standar
    print("El coste de su viaje es: ", resul1)
elif opcion == 2:
    resul2 = duracionViaje * custom
    print("El coste de su viaje es: ", resul2)
elif opcion == 3:
    resul3 = duracionViaje * xtra
    print("El coste de su viaje es: ", resul3)