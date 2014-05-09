# JCalc

`JCalc` is a toy stack-based calculator written in Java. It was made to learn
the Swing API, not as a real project.

## Build

    ant

## Run

    ant run

## Usage

`JCalc` uses a stack, which means you can make complicated operations which
deal with priorities without using parentheses. To add the current value to the
stack, press the “push” button (`<<`). You can now type a new value, and either
push it on the stack or use one of the four simple operations.

An operation pop the top of the stack, applies itself on it and the current
value (in that order), and replace the current value with the result.

You can reset everything at any time with the `R` button.

### Example

We want to compute `(3+5)*(4-2)`. In the following table, the first column shows
the pressed button, the second one shows the resulting value and the last one
the internal stack (top on the right).

| Command | Result | Stack   |
|---------|-------:|:--------|
| `3`     |      3 | `[]`    |
| `<<`    |      0 | `[3]`   |
| `5`     |      5 | `[3]`   |
| `+`     |      8 | `[]`    |
| `<<`    |      0 | `[8]`   |
| `4`     |      4 | `[8]`   |
| `<<`    |      0 | `[8,4]` |
| `2`     |      2 | `[8,4]` |
| `-`     |      2 | `[8]`   |
| `*`     |     16 | `[]`    |


