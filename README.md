# Music Visualiser Project

Name: Alex Tsiogas

Student Number: C20336236

Name: Ron Liquit

Student Number: C20495892

Name: Seán Devilly 

Student Number: C20465804


## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
*Music Visualiser assignment OOP 2021-22*

For our assignment, we have developed a music visualiser using java's processing and minim libraries. It is a visual experience consisting of various visual elements that react to and synchronize with music (our song of choice being "Crystalised" by The xx), and some elements can be controlled by the user via the keyboard. There are (x number) of distinct "renders", which are essentially different screens of visual elements, and the user can change between these screens at their will via the keyboard. The screens are as follows:

- +image
- +image
- +image
- +image

Each visual element is kept in its own class, but use inheritance to access functions and variables from the base class.

We made an effort to keep the colours and visuals harmonious and aesthetically pleasing, and also to match well with the atmosphere of the music.


# Instructions
When the program is run, the user is met with a menu screen. They are directed to press 'g' to begin the visualiser. Upon pressing g, the song begins and the first visual of 5 total is displayed. These 5 visuals can be viewed at any time of the user's choosing, by pressing a key 1 through 5 on their keyboard.

Certain sketches have an added layer of interaction, as they can be conterolled via the 'wasd' keys on the keyboard. Visual 2 can be rotated clockwise or anticlockwise using a or d. The 3D element of Visual 3 can be rotated around the x or y axis in either direction by using the w, a, s or d keys. The user can switch between these visuals and continue to control them for the duration of the song.

# How it works

As mentioned previously, we developed 5 renders in total, and a menu which essentially constitutes a sixth. Each of these renders are stored in their own class. In each class, an instance of the main java file "visual" is created. This visual file extends another java file, "visuals", which contains useful methods for calculating thigs like amplitude and frequency bands. In doing this, we allowed ourselves to access these methods in each render class, and this was essentially how we created the visuals. Each of the renders' render methods are called in the class "visual" at the appropriate time (using a switch statement), to display them on the screen.

*The following is a brief explanation of each visual*

The first visual represents a guitar, and displays first upon beginning the visualiser. It contains 6 strings, created using processing's built in "bezier" function, which was researched. Using the getBands() function, we are able to make each of these beziers change shape, based on frequencies - each one "vibrates" - the parameters of the bezier function change -  when a frequency within their frequency band is detected. Using this, we can give the impression of realistic guitar strings that synchronize to the music, as each one vibrates independently, when certain frequencies are present.

![image](https://user-images.githubusercontent.com/98460373/167168462-5544a931-5c45-4a5a-b4da-7533c1de7b47.png)


The second visual contains a background of sin waves, that react to changes in amplitude using the getAmplitude() function. The centerpiece is made of a collection of shapes made using the "superformula" - a mathematical formula we researched, that creates interesting shapes using some of processing's mathematical functions. This shape also reacts to amplitude, and can be rotated via the keyboard, using processing's "rotate"

![image](https://user-images.githubusercontent.com/98460373/167169198-f340e219-138d-4f04-8d8a-ffe883c9f4e9.png)




# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

