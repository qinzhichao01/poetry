package cracking_the_coding_interview

import (
	"math"
)

// 暴力模拟
func oneEditAway(first string, second string) bool {
	diff := len(first) - len(second)
	if math.Abs(float64(diff)) > 1 {
		return false
	}
	if len(first)+len(second) <= 1 {
		return true

	}
	if len(first) < len(second) {
		var temp = first
		first = second
		second = temp
	}

	bytes1 := []byte(first)
	bytes2 := []byte(second)
	// 只做一次交换
	if diff == 0 {
		var count = 0

		for idx := range bytes2 {
			if bytes2[idx] != bytes1[idx] {
				count++
			}
		}
		if count <= 1 {
			return true
		} else {
			return false
		}
	}
	//
	idx1, idx2, diffCount := 0, 0, 0
	for idx2 < len(bytes2) {
		if diffCount > 1 {
			return false
		}
		if bytes2[idx2] != bytes1[idx1] {
			idx1++
			diffCount++
			continue
		}
		idx1++
		idx2++
	}
	return true
}

func oneEditAway2(first string, second string) bool {
	len1, len2 := len(first), len(second)
	if math.Abs(float64(len2-len1)) > 1 {
		return false
	}
	if len1 > len2 {
		return oneEditAway2(second, first)
	}
	var i, j, cnt int
	byte1, byte2 := []byte(first), []byte(second)
	for i < len1 && j < len2 && cnt <= 1 {
		if byte2[j] == byte1[i] {
			i++
			j++
		} else {
			if len1 == len2 {
				cnt++
				i++
				j++
			} else {
				j++
				cnt++
			}
		}
	}
	return cnt <= 1

}
