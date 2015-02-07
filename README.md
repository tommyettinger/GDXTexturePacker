## GDXTexturePacker

A standalone version of libGDX's TexturePacker with a GUI

LibGDX provides a very full-featured way to pack many images into one texture with its [https://github.com/libgdx/libgdx/wiki/Texture-packer](TexturePacker) tool.  Unfortunately for some developers, it isn't the easiest tool to use. There's a commercial packer with a GUI and an older wrapper around libGDX's TexturePacker, but nothing recent that packs textures for libGDX has had both a GUI and a $0 price tag. This is an attempt to change that, using libGDX's code as a base.

# Usage

There are several downloads on the Releases tab of this project; you probably want the .jar download unless you don't have Java installed. Running the jar or other executable presents you with a simple GUI: select the input folder that contains the images to pack, select the output folder (preferably an empty one, to avoid potentially overwriting something), and optionally a .pack file with additional configuration. The format for .pack files is simple, text-based, similar to JSON, and is [https://github.com/libgdx/libgdx/wiki/Texture-packer#configuration](described here). Click the bottom "Pack Textures!" button and wait for it to complete, which may take a while on larger sets of images. The blue "Processing..." message to the right should change to a green "SUCCESS!" once things are done, or possibly a red "FAILURE..." if something went wrong.  It could also crash if there are far too many images for your computer to handle, which also can occur with libGDX's command-line TexturePacker. Check the output directory you specified and see how well your images compressed!
