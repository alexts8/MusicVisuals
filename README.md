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

# How it works

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

