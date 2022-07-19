<p align="center"><br><img src="https://user-images.githubusercontent.com/35740463/179662295-1fee2543-9c1a-455c-b629-5ed988a5350d.png" width="128" height="128" /></p>
<h3 align="center">Helmet detector</h3>
<p align="center"><strong> Aplicación para la clasificación de personas con casco y sin casco</strong>
</p>

![helmet_video1](https://user-images.githubusercontent.com/35740463/179666123-8796836c-e9d2-4ff7-998c-acb6d30e89c3.gif)
![helmet_video2](https://user-images.githubusercontent.com/35740463/179666129-2ada9ea6-2b9d-4d81-91f9-63d177eb8559.gif)
![helmet_video3](https://user-images.githubusercontent.com/35740463/179666135-3a06eda2-9df9-4e55-8107-549519a058ad.gif)



En este repositorio se podrá encontrar el link al proyecto en Google Colab  [Helmet_detection_model.ipynb](https://github.com/renatojobal/helmet_app_classification/blob/v4.0/Helmet_detection_model.ipynb "Helmet_detection_model.ipynb") y además puedes descargar un apk yendo a los archivos adicionales del [último release](https://github.com/renatojobal/helmet_app_classification/releases).

## Hazlo tu mismo

### Compila la aplicación
#### Requerimientos:
- Android Studio

1. Obtén el código
Clona este repositorio
```
git clone https://github.com/renatojobal/helmet_app_classification.git
```
o descárga el código como archivo comprimido

![image](https://user-images.githubusercontent.com/35740463/179657459-be7d68ac-a0fc-448b-b26e-e82fd96ff75e.png)


2. Ábrelo con Android Studio

![image](https://user-images.githubusercontent.com/35740463/179658244-1517d66b-a506-4973-9ed5-0ceab58139f0.png)

La estructura del proyecto es como cualquier otra aplicación en Android, sin embargo podemos ver que dentro de la carpeta `helmet_app_classification/app/assets/custom_models/` se encuentra el modelo con extensión `.tflite`. En esta carpeta es donde debemos incluir cualquier modelo que hayamos entrenado. Si se trata de entrenar un mismo modelo con mejores resultados sobre la detección de cascos se puede reemplazar el modelo de y guardarlo con el mismo nombre.


### Entrena el modelo
Debes descargar el dataset de fotos comprimido en formato `.tgz`, actualmente lo puedes encontrar junto con el apk en el último release 

1. Entra al [Google Colab](https://github.com/renatojobal/helmet_app_classification/blob/main/Helmet_detection_model.ipynb) 
2. Sube el archivo comprimido en los recursos del Google Colab en formato `.tgz`. También puedes usar tu propio dataset de fotos siempre y cuando sea un comprimido de uina carpeta con la siguinte estructura:

![image](https://user-images.githubusercontent.com/35740463/179660498-24fae7c4-b1fe-4fb8-8572-3920478a1120.png)
 Dentro de las carpetas deben estar las imágenes en formato `.png`
 > El nombre de las carpetas será usado como etiqueta

El comprimido debe estar al mismo nivel que la carpeta sample_data que viene por defecto en el notebook de Google Colab:

![image](https://user-images.githubusercontent.com/35740463/179660909-86ba614f-feaf-451a-bfa1-d5d7d2390e3d.png)

3. Ejecuta el notebook con Ctrl + F9 o ynedo a Runtime > Run all

Te darás cuenta que se descompime el .tgz y es esa la carpeta con los datos que usaremos:

![image](https://user-images.githubusercontent.com/35740463/179661917-0fbdea5b-9df1-43a2-853d-c2c3f7b11c56.png)


Al finalizar la ejecución se te descargará el archivo .tflite que podrás usar en la aplicación movil como se especifica en los pasos previos:
![image](https://user-images.githubusercontent.com/35740463/179661574-25d4de1c-cd66-47c2-b2c1-1f1647393682.png)



<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
## Contribuidores
<table>
  <tr>
    <td align="center"><a href="https://github.com/gmsantos2"><br /><sub><b>Gerson Santos</b></sub></a><br />📖</td>
    <td align="center"><a href="https://github.com/renatojobal"><br /><sub><b>Renato Balcázar</b></sub></a><br />💻</td>
   </tr>
</table>
