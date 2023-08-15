package cracking_the_coding_interview

import "strings"

func replaceSpaces(S string, length int) string {

	builder := strings.Builder{}
	for i := 0; i < length; i++ {
		if S[i] == ' ' {
			builder.WriteString("%20")
		} else {
			builder.WriteByte(S[i])
		}
	}
	return builder.String()
}

func replaceSpaces3(S string, length int) string {
	bytes := []byte(S)
	i, j := len(S)-1, length-1
	for j >= 0 {
		if bytes[j] == ' ' {
			bytes[i] = '0'
			bytes[i-1] = '2'
			bytes[i-2] = '%'
			i = i - 3
		} else {
			bytes[i] = bytes[j]
			i--
		}
		j--
	}
	return string(bytes[i+1:])

}
