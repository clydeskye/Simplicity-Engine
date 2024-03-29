#type vertex
#version 460 core

layout(location = 0) in vec2 aPos;
layout(location = 1) in vec3 aColor;
layout(location = 2) in vec2 aTexCoords;

out vec2 fTexCoords;
out vec3 fColor;

void main() {
    fTexCoords = aTexCoords;
    fColor = aColor;
    gl_Position = vec4(aPos, 1, 1);
}

#type fragment
#version 460 core

in vec2 fTexCoords;
in vec3 fColor;

uniform sampler2D uFontTexture;

out vec4 color;

void main() {
    float c = texture(uFontTexture, fTexCoords).r;
    color = vec4(c, c, c, c) * vec4(fColor, 1);
}