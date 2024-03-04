import sys
import pickle

class color:
    negri = "\033[1m"
    subra = "\033[4m"
    final = "\033[0m"
    rojo = "\033[91m"
    verde = "\033[92m"
    amarillo = "\033[93m"
    azul = "\033[94m"
    magenta = "\033[95m"
    cyan = "\033[96m"

titulo = sys.argv[1:]
titulo = " ".join(titulo).upper()
print("\t\t\t\t" + color.negri + color.subra + titulo + color.final)

with open("../../GradoSuperior1ºAÑO/CarlosRepositorio/Programación/Puntuables/Puntuables 1º Trimestre/Examen/letreros.json", 'rb') as fichero:
    ficheroA = pickle.load(fichero)