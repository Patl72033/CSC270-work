# Grimm, *Fairy Tales*
A citable digital edition

**Status**: In progress.

### Bibliography

Text: `urn:cts:fuTexts:grimms.tales.lyle:`

Plain-text, citable edition following the protocols of the [CITE Architecture](http://cite-architecture.org/)

Edited 11/4/2019

### Running Scripts for Validation, Publication, and Analysis

This repository is an SBT-based project running Scala code. All elements should be independently reproducible.

#### Requirements

- A Java JDK 1.8 or higher.
- SBT Installed and on the PATH.

#### Running

- Clone this repository.
- Navigate to this repository's root level.
- `$ sbt console`
- `scala> :load scripts/corpus-char-validation.sc
etc.`

### Character Validation

This text has been validated against a specific character set using a [Scala Script](https://github.com/Patl72033/CSC270-work/blob/master/corpus-char-validate.sc). Following is a complete listing of the character library for the text, along with corresponding hexadecimal unicode values:

| Character | Character | Character | Character | Character |
|-----------|-----------|-----------|-----------|-----------|
| `space` (20) | `!` (21) | `(` (28) | `)` (29) | `*` (2a) |
| `,` (2c) | `-` (2d) | `.` (2e) | `1` (31) | `2` (32) |
| `3` (33) | `:` (3a) | `;` (3b) | `?` (3f) | `A` (41) |
| `B` (42) | `C` (43) | `D` (44) | `E` (45) | `F` (46) |
| `G` (47) | `H` (48) | `I` (49) | `J` (4a) | `K` (4b) |
| `L` (4c) | `M` (4d) | `N` (4e) | `O` (4f) | `P` (50) |
| `Q` (51) | `R` (52) | `S` (53) | `T` (54) | `U` (55) |
| `V` (56) | `W` (57) | `X` (58) | `Y` (59) | `Z` (5a) |
| `[` (5b) | `]` (5d) | `_` (5f) | `a` (61) | `b` (62) |
| `c` (63) | `d` (64) | `e` (65) | `f` (66) | `g` (67) |
| `h` (68) | `i` (69) | `j` (6a) | `k` (6b) | `l` (6c) |
| `m` (6d) | `n` (6e) | `o` (6f) | `p` (70) | `q` (71) |
| `r` (72) | `s` (73) | `t` (74) | `u` (75) | `v` (76) |
| `w` (77) | `x` (78) | `y` (79) | `z` (7a) | `‘` (2018) |
| `’` (2019) | `“` (201c) | `”` (201d) |

<a rel="license" href="http://creativecommons.org/licenses/by/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by/4.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/4.0/">Creative Commons Attribution 4.0 International License</a>.
