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

import eu.aagsolutions.telematics.exceptions.CRCException

class Codec12(data: String) : Codec<String>(data) {

    @Throws(CRCException::class)
    override fun decode(): String {
        val codecId = getData().substring(16, 18).toInt(16)
        if (codecId != 12) {
            throw CRCException("Invalid codec")
        }
        checkCrc()
        val dataSize = getData().substring(22, 30).toInt(16)
        val rsp = hexStringToByteArray(getData().substring(30, 30 + dataSize * 2))
        return String(rsp, Charsets.UTF_8)
    }


    override fun encode(): String {
        val cmd = getData().toByteArray(Charsets.UTF_8)
        val cmdSize = bytesToHex(toBytes(4, cmd.size))
        val dataSize = bytesToHex(toBytes(4, 1 + 1 + 1 + 4 + cmd.size + 1))
        val completeData = "0C" + "01" + "05" + cmdSize +
                bytesToHex(getData().toByteArray(Charsets.UTF_8)) + "01"

        val crc = calculateCrc(hexStringToByteArray(completeData))

        val completeMsgHex = "00000000" + dataSize +
                completeData + bytesToHex(toBytes(4, crc))
        return completeMsgHex.uppercase()
    }

}