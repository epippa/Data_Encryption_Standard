# DES Algorithm Implementation in Java

This project is a detailed educational implementation of the **Data Encryption Standard (DES)** algorithm in Java. It maps each step of the DES algorithm, as described in the official FIPS 46-3 specification and DESLab assignment, into well-structured Java classes. It includes complete support for both **ECB (Electronic Code Book)** and **CBC (Cipher Block Chaining)** operation modes and integrates a full suite of validation tests.

---

## 📌 Algorithm Overview

The DES is a symmetric block cipher that operates on 64-bit data blocks using a 56-bit key (plus 8 parity bits). The encryption process follows four main phases:

1. **Subkey Generation** using permutation tables PC-1 and PC-2.
2. **Initial Permutation (IP)** applied to each data block.
3. **16 Feistel Rounds** involving expansion, XOR with subkey, substitution using S-boxes, and permutation.
4. **Final Permutation (FP)** to produce the ciphertext.

Decryption is symmetric: it mirrors the encryption steps, simply reversing the order of subkeys.

DES supports two operation modes:
- **ECB**: Encrypts each block independently.
- **CBC**: Chains blocks using XOR with the previous ciphertext block and an IV.

---

## 🧱 Project Structure

### `Utils.java`
Provides helper methods:
- Binary/text conversion.
- Padding and unpadding (zero padding).
- Bitwise operations: XOR, shift, block splitting.

### `SubKeysGenerator.java`
Generates the 16 48-bit subkeys from a 64-bit input key using:
- **PC-1** and **PC-2** permutation tables.
- Predefined circular left shifts.

### `BlockEncoder.java`
Applies the **Initial Permutation (IP)** to a 64-bit plaintext block.

### `RoundPerformer.java`
Executes the **Feistel network** logic:
- Expands the right half from 32 to 48 bits.
- XORs with the current subkey.
- Applies **S-box substitution** and **permutation P**.
- Ends with the **Final Permutation (FP)**.

### `DES.java`
Main controller class:
- Implements `encryptECB`, `decryptECB`, `encryptCBC`, `decryptCBC`.
- Handles block padding, IV chaining (in CBC), and subkey generation.

---

## 🔬 Permutation & Substitution Tables

All DES standard tables are implemented statically:
- **PC-1, PC-2** (Subkey generation).
- **IP, FP** (Initial/Final block permutations).
- **Expansion E**, **Permutation P**, and the **S-boxes** (used in Feistel rounds).

They are used directly in each phase to manipulate bit positions and introduce non-linearity.

---

## 🧪 Testing and Validation

### `Test.java`
Performs high-level validation:
- Verifies ECB and CBC encryption-decryption cycles.
- Ensures that the decrypted result matches the original plaintext.
- Confirms algorithmic correctness using expected input/output values.
- Includes an unpadding test.

### `TestSingleBlock.java`
Focuses on low-level verification:
- Outputs generated subkeys.
- Prints results of Initial Permutation (IP).
- Validates single-block encryption matches known ciphertext.

### Test Files
- `debugging_file.txt`: Logs step-by-step intermediate results for manual comparison.

---

## 🛠️ Design Choices

- Binary strings were used for better clarity and educational value.
- Debugging output is enabled via print statements.
- Padding and unpadding are handled manually for predictable block alignment.
- Symmetric decryption logic reduces code duplication and improves clarity.

---

## 📌 Assignment Mapping

The project is fully aligned with the DESLab assignment:

| Slide Phase                  | Java Implementation         |
|-----------------------------|-----------------------------|
| Subkey Generation           | `SubKeysGenerator.java`     |
| Initial Permutation         | `BlockEncoder.java`         |
| Feistel Rounds              | `RoundPerformer.java`       |
| Final Permutation           | End of `RoundPerformer`     |
| ECB/CBC logic               | `DES.java`                  |
| Permutation/Substitution    | Static arrays in each class |

---

## ✅ Execution Instructions

To run the project:
1. Compile all `.java` files.
2. Run `Test.java` for global validation.
3. Run `TestSingleBlock.java` for detailed single-block inspection.

No external libraries are required. Pure Java standard functionality is used.

---

## 🎓 Educational Purpose

This implementation is intended for instructional use, helping students understand how each part of the DES algorithm translates into actual Java logic. It is based on FIPS PUB 46-3, developed within the DESLab laboratory and conforms to all pedagogical requirements from the assignment. For academic use only.

---

## 👤 Author

**Emanuele Pippa**  
Computer Science student at the Free University of Bolzano
GitHub: [epippa](https://github.com/epippa)

---
