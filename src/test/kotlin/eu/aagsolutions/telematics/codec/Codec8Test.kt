/*
 * Copyright (c) 2024 Aurel Avramescu.
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package eu.aagsolutions.telematics.codec

import eu.aagsolutions.telematics.model.Telemetry
import kotlin.test.Test
import kotlin.test.assertEquals

class Codec8Test {

    private val codec8ex6values =
        "000000000000040b8e06000001881aa960c0000804fad31f4eeb98003900440d001c00000028001e00ef0100f00100" +
                "710000512400522c00eb00028d00029601038201038401038b00038e00039600039700039c0003a00003a10003ac01" +
                "03ad0003ae0003af0003b00003b10003b90003ba0003be0003c10003c60003c80003da000008004233d40011ffb600" +
                "12ff360013001900540096005507ef005a00000073027900020057003f37980362000000a000000000000001881aa9" +
                "64a8000805004b1f4eedf0003a00440e002300000028001e00ef0100f00100710000512500520000eb00028d000296" +
                "01038201038401038b00038e00039600039700039c0003a00003a10003ac0103ad0003ae0003af0003b00003b10003" +
                "b90003ba0003be0003c10003c60003c80003da000008004233cd0011ffda0012ff440013004700540096005506ce00" +
                "5a00000073029a00020057003f37980362000000a000000000000001881aa978300008051a131f4ef84a003c00400e" +
                "001e00000028001e00ef0100f00100710000511b00520000eb00028d00029601038201038401038b00038e01039600" +
                "039700039c0003a00003a10003ac0103ad0003ae0003af0003b00003b10003b90003ba0003be0003c10003c60003c8" +
                "0003da000008004233f40011fff30012ff3a0013001400540096005504cd005a00000073024500020057003f379803" +
                "62000000a000000000000001881aa9800000080520e91f4efb28003d00410e001800000028001e00ef0100f0010071" +
                "0000511400520000eb00028d00029601038201038401038b00038e01039600039700039c0003a00003a10003ac0103" +
                "ad0003ae0003af0003b00003b10003b90003ba0003be0003c10003c60003c80003da000008004233df0011000e0012" +
                "00020013003600540096005504bf005a00000073023a00020057003f37980362000000a000000000000001881aa987" +
                "d000080526b41f4efb7b003e004a0e001100000028001e00ef0100f00100710000511200521200eb00028d00029601" +
                "038201038401038b00038e00039600039700039c0003a00003a10003ac0103ad0003ae0003af0003b00003b10003b9" +
                "0003ba0003be0003c10003c60003c80003da000008004233d60011ffeb0012001c0013005f005400960055049f005a" +
                "00000073023000020057003f37980362000000a000000000000001881aa98fa00008052aad1f4efa2e003f00700e00" +
                "0c00000028001e00ef0100f00100710000511600522e00eb00028d00029601038201038401038b00038e0003960003" +
                "9700039c0003a00003a10003ac0103ad0003ae0003af0003b00003b10003b90003ba0003be0003c10003c60003c800" +
                "03da000008004233e50011ff630012ffb80013002500540096005507f3005a00000073023a00020057003f37fc0362" +
                "000000a000000000060000b426"

    @Test
    fun shouldSuccessfulDecode6Entries() {
        val codec8 = Codec8(codec8ex6values, "defaultImei")
        val values: List<Telemetry> = codec8.decode()
        assertEquals(6, values.size)
    }
}